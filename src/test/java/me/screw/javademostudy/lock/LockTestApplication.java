package me.screw.javademostudy.lock;

import org.junit.jupiter.api.Test;

import javax.persistence.*;
import java.util.List;

public class LockTestApplication {

    @Test
    public void test() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bankUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Bank bank = new Bank();
        bank.setCategory("DEPOSIT2");
        bank.setName("SHINHAN2");

        entityManager.persist(bank);

        transaction.commit();
        entityManager.close();
    }


    @Test
    public void QueryTimeOutExceptionTest() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bankUnit");
        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        EntityManager entityManager2 = entityManagerFactory.createEntityManager();

        new Thread(() -> {
            System.out.println(findBank(entityManager1, 1L, LockModeType.PESSIMISTIC_WRITE, false));
            entityManager1.close();
        }).start();

        new Thread(() -> {
            System.out.println(findBank(entityManager2, 1L, LockModeType.PESSIMISTIC_WRITE, false));
            entityManager2.close();
        }).start();

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * hibernate mysql dialect 에 따라 같은 경우에도 다른 이름의 exception 이 생길 수 있다.
     * mysql8 dialect 와 mysql57 dialect 일때 다르다.
     */
    @Test
    public void NoWaitExceptionTest() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bankUnit");
        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        EntityManager entityManager2 = entityManagerFactory.createEntityManager();

        new Thread(() -> {
            System.out.println(findBank(entityManager1, 1L, LockModeType.PESSIMISTIC_WRITE, true));
            entityManager1.close();
        }).start();

        new Thread(() -> {
            System.out.println(findBank(entityManager2, 1L, LockModeType.PESSIMISTIC_WRITE, true));
            entityManager2.close();
        }).start();

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Bank findBank(
                EntityManager entityManager,
                Long id,
                LockModeType lockModeType,
                boolean isNoWait) {
        EntityTransaction transaction = entityManager.getTransaction();
        System.out.println(transaction + " transaction start");
        transaction.begin();
        Query query = entityManager.createQuery("select b from Bank b where b.id = ?1")
                .setParameter(1, id)
                .setHint("javax.persistence.query.timeout", "2000")
                .setLockMode(lockModeType);
        if (isNoWait) {
            query.setHint("javax.persistence.lock.timeout", "0");
        }
        List<Bank> resultList = query.getResultList();
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(transaction + " transaction end");
        transaction.commit();
        if (resultList == null || resultList.isEmpty()) {
            return null;
        }
        return resultList.get(0);
    }

}