package com.asmith.wikipedia.parser.api;

import java.util.List;

/**
 * @author asmith
 */
public interface MultiValueParser<T> {

    public List<T> parseValue(String value);

}
