package com.asmith.right.rate.wikipedia.table.parser.impl;

import com.asmith.right.rate.domain.constants.Genre;
import com.asmith.wikipedia.parser.api.TableParser;
import com.asmith.wikipedia.parser.api.MultiValueParser;
import com.asmith.wikipedia.parser.api.ReleaseDateParser;
import java.io.IOException;
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
//    @Qualifier(value = "genreValueParser")
    protected MultiValueParser<Genre> genreParser;

    @Autowired
    @Qualifier(value = "developerValueParser")
    protected MultiValueParser developerParser;

    @Autowired
    @Qualifier(value = "publisherValueParser")
    protected MultiValueParser publisherParser;

    @Autowired
    protected ReleaseDateParser releaseDateParser;

    @Autowired
    @Qualifier(value = "addOnValueParser")
    protected MultiValueParser addOnValueParser;

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
