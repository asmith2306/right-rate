package com.asmith.right.rate.wikipedia.parser.impl;

import com.asmith.right.rate.domain.models.Game;
import com.asmith.wikipedia.parser.api.GameTableParser;
import org.jsoup.nodes.Element;

/**
 * @author asmith
 */
public class PS4_GameListParser implements GameTableParser<Game, Element> {

    @Override
    public Game parseRow(Element row) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
