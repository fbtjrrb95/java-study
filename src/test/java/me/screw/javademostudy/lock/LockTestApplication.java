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

    /**
     * 정말? mysql jpa 는 pessimistic-write option 을 무시한다고?
     */
    @Test
    public void QueryTimeOutExceptionTest() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bankUnit");
        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        EntityManager entityManager2 = entityManagerFactory.createEntityManager();

        new Thread(() -> {
            System.out.println(findBank(entityManager1, 1L));
            entityManager1.close();
        }).start();

        new Thread(() -> {
            System.out.println(findBank(entityManager2, 1L));
            entityManager2.close();
        }).start();

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Bank findBank(EntityManager entityManager, Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        System.out.println(transaction + " transaction start");
        transaction.begin();
        List<Bank> resultList = entityManager.createQuery("select b from Bank b where b.id = ?1")
                .setParameter(1, id)
                .setHint("javax.persistence.query.timeout", "2000")
                .setLockMode(LockModeType.PESSIMISTIC_WRITE)
                .getResultList();
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(transaction + " transaction end");
        transaction.commit();
        if (resultList == null || resultList.isEmpty()) return null;
        return resultList.get(0);
    }

}