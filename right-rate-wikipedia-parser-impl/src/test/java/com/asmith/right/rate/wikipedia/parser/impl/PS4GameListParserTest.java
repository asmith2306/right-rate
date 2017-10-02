package com.asmith.right.rate.wikipedia.parser.impl;

import com.asmith.wikipedia.parser.api.TableParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author asmith
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContainerConfig.class})
public class PS4GameListParserTest {

    @Autowired
    @Qualifier("ps4")
    TableParser instance;

    String[] tablePages = {"https://en.wikipedia.org/wiki/List_of_PlayStation_4_games",
        "https://en.wikipedia.org/wiki/List_of_PlayStation_4_games_(M-Z)"};
    String tableId = "softwarelist";

    /**
     * Test of parseTables method, of class PS4GameListParser.
     */
    @Test
    public void testParseTables() {

        instance.parseTables();
    }

}
