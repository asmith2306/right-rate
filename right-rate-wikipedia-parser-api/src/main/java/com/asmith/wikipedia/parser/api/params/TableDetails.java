package com.asmith.wikipedia.parser.api.params;

/**
 * Encapsulates table details that should be passed to APIs
 *
 * @author asmith
 */
public class TableDetails {

    private String tablePage;
    private String[] tablePages;
    private String tableIdentifier;

    public TableDetails(String tablePage, String[] tablePages, String tableIdentifier) {
        this.tablePage = tablePage;
        this.tableIdentifier = tableIdentifier;
        this.tablePages = tablePages;
    }

    public String getTablePage() {
        return tablePage;
    }

    public void setTablePage(String tablePage) {
        this.tablePage = tablePage;
    }

    public String[] getTablePages() {
        return tablePages;
    }

    public void setTablePages(String[] tablePages) {
        this.tablePages = tablePages;
    }

    public String getTableIdentifier() {
        return tableIdentifier;
    }

    public void setTableIdentifier(String tableIdentifier) {
        this.tableIdentifier = tableIdentifier;
    }

}
