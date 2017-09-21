package com.asmith.right.rate.domain.models;

import com.asmith.right.rate.domain.constants.Platform;
import com.asmith.right.rate.domain.constants.Genre;
import com.asmith.right.rate.domain.constants.Region;
import java.time.LocalDate;
import javax.persistence.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author asmith
 */
public class GameTest extends BaseTest {

    @Test
    public void testPersistSuccess() {
        Game game = new Game();
        game.setName("Test Game");
        game.addDeveloper(new Developer("Fake Dev", "www.fakedev.com"));
        game.addPlatform(Platform.PS4);
        game.addGenre(Genre.RPG);
        game.addPublisher(new Publisher("Fake Publisher", "www.fakepublisher.com"));
        game.addReleaseDate(new ReleaseDate(Region.EU, LocalDate.now()));

        em.persist(game);

        Game g = em.find(Game.class, 1L);
        assertEquals(game.getName(), g.getName());
    }

    //@Test
    public void testFindGamesByGenre() {
        Game horrorGame = new Game();
        Game rpgGame = new Game();
        Game horrorRpgGame = new Game();
        Game sciFiGame = new Game();

        horrorGame.addGenre(Genre.HORROR);
        rpgGame.addGenre(Genre.RPG);
        horrorRpgGame.addGenre(Genre.HORROR);
        horrorRpgGame.addGenre(Genre.RPG);
        sciFiGame.addGenre(Genre.SCIFI);

        em.persist(horrorGame);
        em.persist(rpgGame);
        em.persist(horrorRpgGame);
        em.persist(sciFiGame);

        Query q = em.createNamedQuery("findGamesByGenre");

        q.setParameter("genre", Genre.HORROR);
        assertEquals(q.getResultList().size(), 2);

        q.setParameter("genre", Genre.RPG);
        assertEquals(q.getResultList().size(), 2);

        q.setParameter("genre", Genre.SCIFI);
        assertEquals(q.getResultList().size(), 1);
    }

    //@Test
    public void testFindGamesByPlatform() {
        Game ps4Game1 = new Game();
        Game ps4Game2 = new Game();
        Game xboxOneGame = new Game();
        Game wiiUGame = new Game();
        Game pcGame = new Game();
        Game multiplatGame = new Game();

        ps4Game1.addPlatform(Platform.PS4);
        ps4Game2.addPlatform(Platform.PS4);
        xboxOneGame.addPlatform(Platform.XBOX_ONE);
        wiiUGame.addPlatform(Platform.WIIU);
        pcGame.addPlatform(Platform.PC);
        multiplatGame.addPlatform(Platform.PS4);
        multiplatGame.addPlatform(Platform.XBOX_ONE);
        multiplatGame.addPlatform(Platform.PC);

        em.persist(ps4Game1);
        em.persist(ps4Game2);
        em.persist(xboxOneGame);
        em.persist(wiiUGame);
        em.persist(pcGame);
        em.persist(multiplatGame);

        Query q = em.createNamedQuery("findGamesByPlatform");

        q.setParameter("platform", Platform.PS4);
        assertEquals(2, q.getResultList().size());

        q.setParameter("platform", Platform.XBOX_ONE);
        assertEquals(1, q.getResultList().size());

        q.setParameter("platform", Platform.WIIU);
        assertEquals(1, q.getResultList().size());

        q.setParameter("platform", Platform.PC);
        assertEquals(1, q.getResultList().size());
    }

    //@Test
    public void testFindMultiPlatGames() {
        Game ps4Game = new Game();
        Game multiplatGame1 = new Game();
        Game multiplatGame2 = new Game();

        ps4Game.addPlatform(Platform.PS4);

        multiplatGame1.addPlatform(Platform.PS4);
        multiplatGame1.addPlatform(Platform.XBOX_ONE);
        multiplatGame1.addPlatform(Platform.PC);

        multiplatGame2.addPlatform(Platform.PS4);
        multiplatGame2.addPlatform(Platform.XBOX_ONE);
        multiplatGame2.addPlatform(Platform.PC);
        multiplatGame2.addPlatform(Platform.WIIU);

        em.persist(ps4Game);
        em.persist(multiplatGame1);
        em.persist(multiplatGame2);

        Query q = em.createNamedQuery("findMultiPlatGames");

        assertEquals(2, q.getResultList().size());
    }

}
