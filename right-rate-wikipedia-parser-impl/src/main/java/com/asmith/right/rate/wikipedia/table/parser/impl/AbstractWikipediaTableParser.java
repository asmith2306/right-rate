package com.asmith.right.rate.wikipedia.table.parser.impl;

import com.asmith.right.rate.domain.constants.Genre;
import com.asmith.right.rate.domain.models.Creator;
import com.asmith.right.rate.domain.models.Developer;
import com.asmith.right.rate.domain.models.Publisher;
import com.asmith.wikipedia.parser.api.TableParser;
import com.asmith.wikipedia.parser.api.ValueParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author asmith
 * @param <T>
 */
public abstract class AbstractWikipediaTableParser<T> implements TableParser<T> {

    @Value("${wikipedia.base.url}")
    protected String wikipediaBaseUrl;

    @Autowired
    @Qualifier(value = "genreValueParser")
    protected ValueParser genreParser;

    @Autowired
    @Qualifier(value = "developerValueParser")
    protected ValueParser developerParser;

    @Autowired
    @Qualifier(value = "publisherValueParser")
    protected ValueParser publisherParser;

    @Autowired
    @Qualifier(value = "platformParser")
    protected ValueParser platformParser;

    public Element getTable(String tablePage, String tableId) {
        try {
            return Jsoup.connect(tablePage).maxBodySize(0).get().getElementById(tableId);
        } catch (IOException ex) {
            Logger.getLogger(AbstractWikipediaTableParser.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override // delegate the parsing to sub classes
    public abstract List<T> parseTables();
}
