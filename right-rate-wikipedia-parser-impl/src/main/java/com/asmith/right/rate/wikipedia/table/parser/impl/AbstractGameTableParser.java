package com.asmith.right.rate.wikipedia.table.parser.impl;

import com.asmith.right.rate.domain.constants.AddOn;
import com.asmith.right.rate.domain.constants.Genre;
import com.asmith.right.rate.domain.models.Developer;
import com.asmith.right.rate.domain.models.Publisher;
import com.asmith.wikipedia.parser.api.TableParser;
import com.asmith.wikipedia.parser.api.MultiValueParser;
import com.asmith.wikipedia.parser.api.ReleaseDateParser;
import com.asmith.wikipedia.parser.api.TableRetriever;
import java.util.List;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author asmith
 * @param <T>
 */
public abstract class AbstractGameTableParser<T> implements TableParser<T> {

    @Value("${wikipedia.red.href.indicator}")
    private String redLinkIndicator;

    @Autowired
    protected TableRetriever<Element> tableRetriever;

    @Autowired
    protected MultiValueParser<Genre> genreParser;

    @Autowired
    protected MultiValueParser<Developer> developerParser;

    @Autowired
    protected MultiValueParser<Publisher> publisherParser;

    @Autowired
    protected ReleaseDateParser releaseDateParser;

    @Autowired
    protected MultiValueParser<AddOn> addOnValueParser;
    
    /**
     * A games href/link is only acceptable if
     * - the href isn't empty
     * - the href isn't red (indicates link to a non existing page)
     * @param currentGameHref
     * @return 
     */
    protected boolean hrefIsAcceptable(String currentGameHref) {
        return !currentGameHref.isEmpty()
                && !currentGameHref.contains(redLinkIndicator);
    }
}
