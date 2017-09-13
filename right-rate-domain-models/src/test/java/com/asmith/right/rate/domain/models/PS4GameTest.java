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

    @Before()
    public void setupGame() {
        game = new PS4Game();
        game.setName("Test Game");
        game.addDeveloper(new Developer("Fake Dev Inc.", "www.fakedev.com"));
        game.addExclusive(Exclusive.CONSOLE);
        game.addGenre(Genre.RPG);
        game.addGenre(Genre.ADVENTURE);
        game.addPublisher(new Publisher("Fake Publisher Inc.", "www.fakepublisher.com"));
        game.addReleaseDate(new ReleaseDate(Region.EU, LocalDate.now()));
        game.addAddOn("VR");
    }

    @Test
    public void testPersistSuccess() {
        em.getTransaction().begin();
        em.persist(game);
        em.getTransaction().commit();

        PS4Game gameInDb = em.find(PS4Game.class, 1L);
       // System.out.println(gameInDb);

        Query nq = em.createNamedQuery("findPS4GameByGenre");
        nq.setParameter("genre", Genre.SCIFI);
        List<PS4Game> games = nq.getResultList();
        System.out.println(games);
    }

}
