package com.asmith.right.rate.wikipedia.table.parser.impl;

import com.asmith.right.rate.domain.models.Game;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author asmith
 */
@Service("ps4GameTableParser")
public class PS4GameTableParserImpl extends AbstractWikipediaTableParser<Game> {

    @Value("${wikipedia.ps4.game.list.urls}")
    private String tableUrls;

    @Value("${wikipedia.ps4.game.list.id}")
    private String tableId;

    @Override
    public List<Game> parseTables() {

        List<Game> gamesToReturn = new ArrayList<>();
        Game currentGame;
        Element currentRow;
        Element table;
        String currentGameHref;

        for (String tablePage : tableUrls.split(",")) {
            table = super.getTable(tablePage, tableId);

            if (null != table) {
                Elements rows = table.select("tr");
                for (int i = 2; i < rows.size(); i++) { //first two rows contain headers so skip
                    currentRow = rows.get(i);
                    if (currentRow.select("td:nth-child(1) > i > a").hasAttr("href")) { // only use games that have a link to a wiki page
                        currentGameHref = currentRow.select("td:nth-child(1) > i > a").attr("abs:href");

                        currentGame = new Game();
                        currentGame.setName(currentRow.select("td:nth-child(1) > i > a").text());
                        System.out.println(currentGame.getName());

                        //add genres
                        if (currentGame.setGenres(genreParser.parseValue(currentRow.select("td:nth-child(2)").text())).isEmpty()) {
                            continue; // not interested in games that fall outside the supported genres
                        }
                        currentGame.getGenres().forEach(genre -> {
                            System.out.println(genre.getDescription());
                        });

                        //add devs
                        if (currentGame.setDevelopers(developerParser.parseValue(currentRow.select("td:nth-child(3)").text())).isEmpty()) {
                            continue; // not interested in games that have no developers
                        }
                        currentGame.getDevelopers().forEach(dev -> {
                            System.out.println(dev.getName());
                        });

                        //add publishers
                        if (currentGame.setPublishers(publisherParser.parseValue(currentRow.select("td:nth-child(4)").text())).isEmpty()) {
                            continue; // not interested in games that have no publishers
                        }
                        currentGame.getPublishers().forEach(pub -> {
                            System.out.println(pub.getName());
                        });

                        //add exclusivity
                        if (currentGame.setExclusivity(currentRow.select("td:nth-child(4)").text())) {
                            continue; // not interested in games that have no publishers
                        }
                        currentGame.getPublishers().forEach(pub -> {
                            System.out.println(pub.getName());
                        });

//                        System.out.println(currentRow.select("td:nth-child(1)"));
//                        System.out.println(currentRow.select("td:nth-child(2)"));
//                        System.out.println(currentRow.select("td:nth-child(3)"));
//                        System.out.println(currentRow.select("td:nth-child(4)"));
//                        System.out.println(currentRow.select("td:nth-child(5)"));
//                        System.out.println(currentRow.select("td:nth-child(6)"));
//                        System.out.println(currentRow.select("td:nth-child(7)"));
//                        System.out.println(currentRow.select("td:nth-child(8)"));
//                        System.out.println(currentRow.select("td:nth-child(9)"));
//                        System.out.println("Game href: " + currentGameHref);
                        System.out.println();
                    }
                }

            }
        }

        return gamesToReturn;
    }

}
