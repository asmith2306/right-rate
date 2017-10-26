package com.asmith.wikipedia.parser.api;

/**
 * @author asmith
 */
public interface DynamicTableParser<T> extends TableParser<T> {

    void setTablePage(String tablePage);
}
