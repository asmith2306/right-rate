package com.asmith.wikipedia.parser.api;

/**
 * @author asmith
 * @param <T> type to return
 * @param <E> the element type to parse the release date from
 * @param <R> the release date region representation
 */
public interface ReleaseDateParser<T, E, R> {

    public T parseValue(E element, R region);

}
