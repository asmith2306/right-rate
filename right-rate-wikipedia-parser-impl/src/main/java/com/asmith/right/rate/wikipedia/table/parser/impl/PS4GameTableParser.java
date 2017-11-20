package com.asmith.right.rate.wikipedia.table.parser.impl;

import com.asmith.right.rate.domain.constants.Region;
import com.asmith.right.rate.domain.constants.Xclusivity;
import com.asmith.right.rate.domain.models.Game;
import com.asmith.right.rate.domain.models.ReleaseDate;
import com.asmith.wikipedia.parser.api.XclusivityParser;
import com.asmith.wikipedia.parser.api.params.TableDetails;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author asmith
 */
@Service("ps4GameTableParser")
public class PS4GameTableParser extends AbstractGameTableParser<Game> {

    @Value("${wikipedia.ps4.game.list.urls}")
    private String tableUrls;

    @Value("${wikipedia.ps4.game.list.id}")
    private String tableId;

    @Autowired
    @Qualifier(value = "ps4XclusivityValueParser")
    private XclusivityParser ps4XclusivityParser;

    @Override
    public List<Game> parseTables() {

        List<Game> gamesToReturn = new ArrayList<>();
        Game currentGame;
        Element currentRow;
        Element gameTable;
        String currentGameHref;

        for (String tablePage : tableUrls.split(",")) {
            gameTable = tableRetriever.getTableById(new TableDetails(tablePage, tableId));

            if (null != gameTable) {
                Elements rows = gameTable.select("tr");
                for (int i = 2; i < rows.size(); i++) { //first two rows contain headers so skip
                    currentRow = rows.get(i);
                    currentGameHref = currentRow.select("td:nth-child(1) > i > a").attr("abs:href");

                    if (super.hrefIsAcceptable(currentGameHref)) {
                        currentGame = new Game();

                        currentGame.setName(currentRow.select("td:nth-child(1) > i > a").text());

                        //add reviews
                        reviewTableParser.setTablePage(currentGameHref);
                        currentGame.setReviews(reviewTableParser.parseTables());
                        if (currentGame.getReviews().isEmpty()) {
                            continue; // not interested in games that have no reviews
                        }
                        System.out.println(currentGame.getName());
                        currentGame.getReviews().forEach(review -> {
                            System.out.println(review);
                        });

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
                        currentGame.setExclusivity((Xclusivity) ps4XclusivityParser.parseExclusivity(currentRow.select("td:nth-child(5)").text()));
                        System.out.println(currentGame.getExclusivity().getDescription());

                        currentGame.addReleaseDate((ReleaseDate) releaseDateParser.parseValue(currentRow.select("td:nth-child(6)"), Region.JP));
                        currentGame.addReleaseDate((ReleaseDate) releaseDateParser.parseValue(currentRow.select("td:nth-child(7)"), Region.EU));
                        currentGame.addReleaseDate((ReleaseDate) releaseDateParser.parseValue(currentRow.select("td:nth-child(8)"), Region.NA));
                        currentGame.getReleaseDates().forEach(release -> {
                            System.out.println(release);
                        });

                        //add add ons
                        currentGame.setAddOns(addOnValueParser.parseValue(currentRow.select("td:nth-child(9)").text()));
                        currentGame.getAddOns().forEach(addOn -> {
                            System.out.println(addOn.getDescription());
                        });

                        System.out.println();
                    }
                }

            }
        }

        return gamesToReturn;
    }

}
