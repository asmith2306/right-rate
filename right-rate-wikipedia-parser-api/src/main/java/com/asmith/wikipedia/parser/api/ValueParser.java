package com.asmith.wikipedia.parser.api;

/**
 * @author asmith
 * @param <T>
 */
public interface ValueParser<T> {

    public T parseValue(String value);

}
