package com.asmith.right.rate.wikipedia.parser.impl;

import com.asmith.right.rate.domain.models.Game;
import com.asmith.wikipedia.parser.api.TableParser;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author asmith
 */
@Service
public class PS4_GameListParser implements TableParser<Game> {

    @Override
    public List<Game> parseTable(org.jsoup.select.Elements rows) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
