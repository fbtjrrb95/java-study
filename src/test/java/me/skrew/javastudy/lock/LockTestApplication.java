package me.skrew.javastudy.lock;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Tag("lock")
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


    // TODO: entityManager.find 로 바꾸니깐 왜 queryTimeOutException 이 나지 않는 거지?
    @Test
    public void QueryTimeOutExceptionTest() {
        Map<String, Object> props = new HashMap<>();
        props.put("javax.persistence.lock.timeout", 1_000);
        props.put("javax.persistence.query.timeout", 1_000);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bankUnit", props);
        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        EntityManager entityManager2 = entityManagerFactory.createEntityManager();

        new Thread(() -> {
            System.out.println(findBank(entityManager1, 1L, LockModeType.PESSIMISTIC_WRITE));
            entityManager1.close();
        }).start();

        new Thread(() -> {
            System.out.println(findBank(entityManager2, 1L, LockModeType.PESSIMISTIC_WRITE));
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
        Map<String, Object> props = new HashMap<>();
        props.put("javax.persistence.lock.timeout", 0);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bankUnit", props);
        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        EntityManager entityManager2 = entityManagerFactory.createEntityManager();

        new Thread(() -> {
            System.out.println(findBank(entityManager1, 1L, LockModeType.PESSIMISTIC_WRITE));
            entityManager1.close();
        }).start();

        new Thread(() -> {
            System.out.println(findBank(entityManager2, 1L, LockModeType.PESSIMISTIC_WRITE));
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
                LockModeType lockModeType) {
        EntityTransaction transaction = entityManager.getTransaction();
        System.out.println(transaction + " transaction start");
        transaction.begin();
        Bank bank = entityManager.find(Bank.class, id, lockModeType);
        entityManager.flush();
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(transaction + " transaction end");
        transaction.commit();
        return bank;
    }

}