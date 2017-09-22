package com.asmith.right.rate.domain.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;

public class BaseTest {

    protected static EntityManagerFactory emf;
    protected static EntityManager em;

    @Before()
    public void beginTransaction() {
        // every time we create the emf-factory it performs the schema-generation.database.action from the PU i.e. we wipe the tables for each test
        emf = Persistence.createEntityManagerFactory("com.asmith.right.rate.domain.models.test.PU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @After
    public void endTransaction() {
        em.getTransaction().commit();
        em.clear();
        em.close();
        emf.close();
    }
}
