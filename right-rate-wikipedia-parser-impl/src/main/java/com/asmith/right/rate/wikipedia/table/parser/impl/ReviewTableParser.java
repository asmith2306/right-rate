package com.asmith.right.rate.wikipedia.table.parser.impl;

import com.asmith.right.rate.domain.models.Review;
import com.asmith.wikipedia.parser.api.DynamicTableParser;
import java.util.List;
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

    @Override
    public List<Review> parseTables() {
        System.out.println("Parsing review table on page:" + tablePage);
        return null;
    }

    @Override
    public void setTablePage(String tablePage) {
        this.tablePage = tablePage;
    }

}
