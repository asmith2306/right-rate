package com.asmith.wikipedia.parser.api;

import java.util.List;
import org.jsoup.select.Elements;

/**
 * parse API for Wikipedia listing tables e.g.
 * https://en.wikipedia.org/wiki/List_of_PlayStation_4_games
 *
 * @author asmith
 * @param <T> type to return
 */
public interface TableParser<T> {

   public List<T> parseTable(Elements rows);
}
