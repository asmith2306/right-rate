/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asmith.right.rate.domain.models;

import java.util.List;
import javax.persistence.Query;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Alan
 */
public class DeveloperTest extends BaseTest {

    @Test
    public void testFindDeveloperByName() {
        Developer dev1 = new Developer("Fake Dev 1", "www.fakedev1.com");
        Developer dev2 = new Developer("Fake Dev 2", "www.fakedev2.com");

        em.persist(dev1);
        em.persist(dev2);

        Query q = em.createNamedQuery("findDeveloperByName");

        q.setParameter("name", "Fake Dev 1");
        assertEquals(q.getResultList().size(), 1);

        q.setParameter("name", "Fake Dev 2");
        assertEquals(q.getResultList().size(), 1);

        q.setParameter("name", "Fake Dev 3");
        assertEquals(q.getResultList().size(), 0);
    }

}
