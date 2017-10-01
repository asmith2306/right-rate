package com.asmith.right.rate.wikipedia.parser.impl;

import com.asmith.right.rate.domain.models.Game;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author asmith
 */
public class PS4_GameListParserTest {

    @BeforeClass
    public static void setup() throws IOException {
        String url = "https://en.wikipedia.org/wiki/List_of_PlayStation_4_games";
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
        String title = doc.title();
        System.out.println(title);
        Element table = doc.getElementById("softwarelist");
     
    }

    /**
     * Test of parseRow method, of class PS4_GameListParser.
     */
    @Test
    public void testParseRow() {
        PS4_GameListParser instance = new PS4_GameListParser();
    }

}
