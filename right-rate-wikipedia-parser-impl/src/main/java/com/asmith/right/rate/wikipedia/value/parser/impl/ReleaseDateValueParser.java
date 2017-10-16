package com.asmith.right.rate.wikipedia.value.parser.impl;

import com.asmith.right.rate.domain.constants.Region;
import com.asmith.right.rate.domain.models.ReleaseDate;
import com.asmith.wikipedia.parser.api.ReleaseDateParser;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

/**
 * @author asmith
 */
@Service
public class ReleaseDateValueParser implements ReleaseDateParser<ReleaseDate, Elements, Region> {

    @Override
    public ReleaseDate parseValue(Elements elements, Region region) {
        ReleaseDate releaseDateToReturn = new ReleaseDate();
        releaseDateToReturn.setRegion(region);

        Elements dateElements = elements.select("span:nth-child(2)");
        if ("".equals(dateElements.text())) {
            switch (elements.text()) {
                case "TBA":
                    releaseDateToReturn.setDate("TBA");
                    break;
                case "Unreleased":
                    releaseDateToReturn.setDate("Unreleased");
                    break;
                case "Assorted":
                    releaseDateToReturn.setDate("Assorted");
                    break;
                default:
                    releaseDateToReturn.setDate(elements.text().substring(8, elements.text().indexOf("-")));
            }
        } else {
            releaseDateToReturn.setDate(dateElements.text());
        }

        return releaseDateToReturn;
    }

}
