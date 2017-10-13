package com.asmith.wikipedia.parser.api;

/**
 * @author asmith
 */
public interface XclusivityParser<T> {
    T parseExclusivity(String value);
}
