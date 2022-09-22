package me.screw.javademostudy.lock;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.persistence.*;

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
    public void LockTimeOutExceptionTest() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bankUnit");
        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
        new Thread(() -> {
            findBank(entityManager1, 1L);
        }).start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            findBank(entityManager2, 1L);
        }).start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Bank findBank(EntityManager entityManager, Long id) {
        System.out.println(Thread.currentThread().getId() + " thread start");
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Bank bank = entityManager.find(Bank.class, id, LockModeType.PESSIMISTIC_WRITE);
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId() + " thread end");
        transaction.commit();
        entityManager.close();
        return bank;
    }

}