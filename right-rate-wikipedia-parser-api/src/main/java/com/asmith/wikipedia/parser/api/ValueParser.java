package com.asmith.wikipedia.parser.api;

import java.util.List;

/**
 * @author asmith
 * @param <T>
 */
public interface ValueParser<T> {

    public List<T> parseValue(String value);

}
