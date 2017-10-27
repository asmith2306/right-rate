package com.asmith.right.rate.wikipedia.table.parser.impl;

import com.asmith.right.rate.domain.models.Review;
import com.asmith.wikipedia.parser.api.DynamicTableParser;
import com.asmith.wikipedia.parser.api.TableRetriever;
import com.asmith.wikipedia.parser.api.params.TableDetails;
import java.util.List;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author asmith
 */
@Service
public class ReviewTableParser implements DynamicTableParser<Review> {

    @Value("${wikipedia.game.review.table.class}")
    private String tableClass;

    private String tablePage;

    @Autowired
    protected TableRetriever<Element> tableRetriever;

    @Override
    public List<Review> parseTables() {

        List<Element> allTables = tableRetriever.getTablesByClass(new TableDetails(tablePage, tableClass));

        Element reviewTable = allTables.get(0); // pages only ever have one review table
        Elements tableRows = reviewTable.select("tr");

        boolean publicationRowFound = false;

        for (Element row : tableRows) {
            if (publicationRowFound) {
                System.out.println(row);
                System.out.println();
            } else if (row.text().contains("Publication")) {
                publicationRowFound = true;
            }
        }

        return null;
    }

    @Override
    public void setTablePage(String tablePage) {
        this.tablePage = tablePage;
    }

}
