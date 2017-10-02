package com.asmith.right.rate.wikipedia.parser.impl;

import com.asmith.wikipedia.parser.api.TableParser;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

/**
 * @author asmith
 * @param <T>
 */
public abstract class AbstractWikipediaTableParser<T> implements TableParser<T> {

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
