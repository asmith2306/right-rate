package com.asmith.right.rate.wikipedia.parser.impl;

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
@Service("ps4")
public class PS4GameListParser extends AbstractWikipediaTableParser<Game> {

    @Value("${ps4.game.list.urls}")
    private String tableUrls;

    @Value("${ps4.game.list.id}")
    private String tableId;

    @Override
    public List<Game> parseTables() {

        List<Game> games = new ArrayList<>();
        Element table;

        for (String tablePage : tableUrls.split(",")) {
            table = super.getTable(tablePage, tableId);

            if (null != table) {
                Elements rows = table.select("tr");
                for (int i = 2; i < rows.size(); i++){ //first two rows contain headers so skip
                    System.out.print(rows.get(i));
                }
                
                
            }

        }
        
        return games;
    }

}
