package com.asmith.wikipedia.parser.api.params;

/**
 * Encapsulates table details that should be passed to APIs
 *
 * @author asmith
 */
public class TableDetails {

    private String tablePage;
    private String tableIdentifier;

    public TableDetails(String tablePage, String tableIdentifier) {
        this.tablePage = tablePage;
        this.tableIdentifier = tableIdentifier;
    }

    public String getTablePage() {
        return tablePage;
    }

    public void setTablePage(String tablePage) {
        this.tablePage = tablePage;
    }

    public String getTableIdentifier() {
        return tableIdentifier;
    }

    public void setTableIdentifier(String tableIdentifier) {
        this.tableIdentifier = tableIdentifier;
    }

    @Override
    public String toString() {
        return "TableDetails{" + "tablePage=" + tablePage + ", tableIdentifier=" + tableIdentifier + '}';
    }

}
