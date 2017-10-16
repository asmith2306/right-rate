package com.asmith.right.rate.wikipedia.table.parser.impl;

import com.asmith.right.rate.domain.models.Review;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author asmith
 */
@Service("wikipediaReviewTableParser")
public class WikipediaReviewTableParser extends AbstractWikipediaTableParser<Review>{

    @Override
    public List<Review> parseTables() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
