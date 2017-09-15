package com.asmith.right.rate.domain.models;

import com.asmith.right.rate.domain.constants.Exclusive;
import com.asmith.right.rate.domain.constants.Genre;
import com.asmith.right.rate.domain.constants.Region;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Query;
import org.junit.Before;
import org.junit.Test;

/**
 * @author asmith
 */
public class PS4GameTest extends BaseTest {

    private PS4Game game;
    private Developer dev;
    private Publisher pub;

    @Before()
    public void setupGame() {
        game = new PS4Game();
        dev = new Developer("Fake Dev Inc.", "www.fakedev.com");
        pub = new Publisher("Fake Publisher Inc.", "www.fakepublisher.com");

        game.setName("Test Game");
        game.addDeveloper(dev);
        game.addExclusive(Exclusive.CONSOLE);
        game.addGenre(Genre.RPG);
        game.addGenre(Genre.ADVENTURE);
        game.addPublisher(pub);
        game.addReleaseDate(new ReleaseDate(Region.EU, LocalDate.now()));
        game.addAddOn("VR");

        dev.addGame(game);
        pub.addGame(game);
    }

    @Test
    public void testPersistSuccess() {
        em.getTransaction().begin();
        em.persist(game);
        em.persist(dev);
        em.persist(pub);
        em.getTransaction().commit();

        Query nq = em.createNamedQuery("findPS4GamesByGenre");
        nq.setParameter("genre", Genre.RPG);
        List<PS4Game> games = nq.getResultList();
        System.out.println("The games " + games);

        nq = em.createNamedQuery("findPS4GamesByDeveloper");
        nq.setParameter("developer", dev);
        games = nq.getResultList();
        System.out.println("The games " + games);
    }

}
