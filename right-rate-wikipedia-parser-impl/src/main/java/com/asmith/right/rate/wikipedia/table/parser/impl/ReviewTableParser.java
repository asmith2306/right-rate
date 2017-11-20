package com.asmith.right.rate.wikipedia.table.parser.impl;

import com.asmith.right.rate.domain.models.Review;
import com.asmith.wikipedia.parser.api.DynamicTableParser;
import com.asmith.wikipedia.parser.api.TableRetriever;
import com.asmith.wikipedia.parser.api.params.TableDetails;
import java.util.ArrayList;
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
        List<Review> reviewsToReturn = new ArrayList<>();

        if (allTables.isEmpty()) {
            return reviewsToReturn;
        }

        Element reviewTable = allTables.get(0); // pages only ever have one review table
        Elements tableRows = reviewTable.select("tr");

        boolean publicationRowFound = false;

        Review currentReview;

        for (Element row : tableRows) {
            if (publicationRowFound) {
                if (!row.select("td:nth-child(2)").text().contains("/") ||
                        row.select("td:nth-child(2)").text().indexOf("[") == -1) {
                    continue; // don't bother with star type reviews or multi play review tables for the moment
                }

                // for the moment don't bother getting the review url and snippet for any review
                currentReview = new Review(row.select("td:nth-child(2)").text().substring(0, row.select("td:nth-child(2)").text().indexOf("[")), null, row.select("td:nth-child(1)").text(), null);
                reviewsToReturn.add(currentReview);
            } else if (row.text().contains("Publication")) {
                publicationRowFound = true;
            }
        }

        return reviewsToReturn;
    }

    @Override
    public void setTablePage(String tablePage) {
        this.tablePage = tablePage;
    }

}
