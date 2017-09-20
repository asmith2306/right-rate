/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asmith.right.rate.domain.models;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;

public class BaseTest {

    protected static EntityManagerFactory emf;
    protected static EntityManager em;

    @Before()
    public void beginTransaction() {
        em.getTransaction().begin();
    }

    @After
    public void rollbackTransaction() {
        em.getTransaction().rollback();
    }

    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {
        emf = Persistence.createEntityManagerFactory("com.asmith.right.rate.domain.models.test.PU");
        em = emf.createEntityManager();
    }

    @AfterClass
    public static void tearDown() {
        em.clear();
        em.close();
        emf.close();
    }
}
