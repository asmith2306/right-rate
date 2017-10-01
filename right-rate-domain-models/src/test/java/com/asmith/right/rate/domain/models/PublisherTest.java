/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asmith.right.rate.domain.models;

import javax.persistence.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Alan
 */
public class PublisherTest extends TestBase {

    @Test
    public void testFindPublisherByName() {
        Publisher pub1 = new Publisher("Fake Pub 1", "www.fakepublisher1.com");
        Publisher pub2 = new Publisher("Fake Pub 2", "www.fakepublisher2.com");

        em.persist(pub1);
        em.persist(pub2);

        Query q = em.createNamedQuery("findPublisherByName");

        q.setParameter("name", "Fake Pub 1");
        assertEquals(1, q.getResultList().size());

        q.setParameter("name", "Fake Pub 2");
        assertEquals(1, q.getResultList().size());

        q.setParameter("name", "Fake Pub 3");
        assertEquals(0, q.getResultList().size());
    }

}
