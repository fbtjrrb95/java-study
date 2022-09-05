package me.screw.javademostudy.lock;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.*;

public class LockTestApplication {

//    @PersistenceContext(unitName = "bankUnit")
    private EntityManager entityManager;

    @BeforeEach
    public void setUp() {
        System.out.println(getClass().getResource("META-INF/persistence.xml"));
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bankUnit");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach
    public void release() {
        entityManager.close();
    }

    @Test
    public void test() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Bank bank = new Bank();
        bank.setCategory("DEPOSIT");
        bank.setName("SHINHAN");

        entityManager.persist(bank);

        transaction.commit();
    }



}
