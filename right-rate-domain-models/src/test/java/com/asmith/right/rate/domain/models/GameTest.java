package com.asmith.right.rate.domain.models;

import com.asmith.right.rate.domain.constants.Platform;
import com.asmith.right.rate.domain.constants.Genre;
import com.asmith.right.rate.domain.constants.Region;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for Game entity that tests the named queries
 *
 * @author asmith
 */
public class GameTest extends BaseTest {

    // Game names that can be used in various tests
    private final String uncharted = "Uncharted";
    private final String lastOfUs = "Last Of Us";
    private final String battlefield = "Battlefield";
    private final String battlefront = "Battlefront";
    private final String horizon = "Horizon";

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

    @Test
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
        assertEquals(2, q.getResultList().size());

        q.setParameter("genre", Genre.RPG);
        assertEquals(2, q.getResultList().size());

        q.setParameter("genre", Genre.SCIFI);
        assertEquals(1, q.getResultList().size());
    }

    @Test
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

    @Test
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

    @Test
    public void testFindGamesByDeveloper() {
        List<Game> retrievedGames;

        Developer dev1 = new Developer("Naughty Dog", "www.nd.com");
        Developer dev2 = new Developer("DICE", "www.dice.com");
        Developer dev3 = new Developer("Guerilla Games", "www.gg.com");

        Game game1 = new Game();
        game1.setName(uncharted);
        game1.addDeveloper(dev1); //nd game

        Game game2 = new Game();
        game2.setName(battlefield);
        game2.addDeveloper(dev2); //dice game

        Game game3 = new Game();
        game3.setName(horizon);
        game3.addDeveloper(dev3); //guerilla game

        Game game4 = new Game();
        game4.setName(lastOfUs);
        game4.addDeveloper(dev1); //nd game

        Game game5 = new Game();
        game5.setName(battlefront);
        game5.addDeveloper(dev2); //dice game

        em.persist(game1);
        em.persist(game2);
        em.persist(game3);
        em.persist(game4);
        em.persist(game5);

        Query q = em.createNamedQuery("findGamesByDeveloper");

        q.setParameter("name", "Naughty Dog");
        retrievedGames = q.getResultList();
        assertEquals(2, retrievedGames.size());
        assertEquals(uncharted, retrievedGames.get(0).getName());
        assertEquals(lastOfUs, retrievedGames.get(1).getName());

        q.setParameter("name", "DICE");
        retrievedGames = q.getResultList();
        assertEquals(2, retrievedGames.size());
        assertEquals(battlefield, retrievedGames.get(0).getName());
        assertEquals(battlefront, retrievedGames.get(1).getName());

        q.setParameter("name", "Guerilla Games");
        retrievedGames = q.getResultList();
        assertEquals(1, retrievedGames.size());
        assertEquals(horizon, retrievedGames.get(0).getName());

        q.setParameter("name", "Fake dev"); // this dev isn't in the db
        retrievedGames = q.getResultList();
        assertEquals(0, retrievedGames.size());

    }

    @Test
    public void testFindGamesByPublisher() {
        List<Game> retrievedGames;

        Publisher pub1 = new Publisher("Sony", "www.sony.com");
        Publisher pub2 = new Publisher("EA", "www.ea.com");

        Game game1 = new Game();
        game1.setName(uncharted);
        game1.addPublisher(pub1); //nd game

        Game game2 = new Game();
        game2.setName(battlefield);
        game2.addPublisher(pub2); //dice game

        Game game3 = new Game();
        game3.setName(horizon);
        game3.addPublisher(pub1); //guerilla game

        Game game4 = new Game();
        game4.setName(lastOfUs);
        game4.addPublisher(pub1); //nd game

        Game game5 = new Game();
        game5.setName(battlefront);
        game5.addPublisher(pub2); //dice game

        em.persist(game1);
        em.persist(game2);
        em.persist(game3);
        em.persist(game4);
        em.persist(game5);

        Query q = em.createNamedQuery("findGamesByPublisher");

        q.setParameter("name", "Sony");
        retrievedGames = q.getResultList();
        assertEquals(3, retrievedGames.size());
        assertEquals(uncharted, retrievedGames.get(0).getName());
        assertEquals(horizon, retrievedGames.get(1).getName());
        assertEquals(lastOfUs, retrievedGames.get(2).getName());

        q.setParameter("name", "EA");
        retrievedGames = q.getResultList();
        assertEquals(2, retrievedGames.size());
        assertEquals(battlefield, retrievedGames.get(0).getName());
        assertEquals(battlefront, retrievedGames.get(1).getName());

        q.setParameter("name", "Fake publisher"); // this publisher isn't in the db
        retrievedGames = q.getResultList();
        assertEquals(0, retrievedGames.size());
    }

}
