package com.asmith.wikipedia.parser.api;

/**
 * parse API for Wikipedia game listing tables
 * e.g. https://en.wikipedia.org/wiki/List_of_PlayStation_4_games
 * @author asmith
 * @param <T> type to return
 * @param <E> type to parse
 */
public interface GameTableParser<T,E> {
    public T parseRow(E row);
}
