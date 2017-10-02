package com.asmith.wikipedia.parser.api;

import java.util.List;

/**
 * parse API for Wikipedia tables
 *
 * @author asmith
 * @param <T> type to return
 */
public interface TableParser<T> {
    
    /**
     * Parse the tables
     * @return 
     */
    public List<T> parseTables();

}
