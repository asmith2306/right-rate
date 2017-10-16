package com.asmith.right.rate.wikipedia.value.parser.impl;

import com.asmith.right.rate.domain.models.Publisher;
import com.asmith.wikipedia.parser.api.MultiValueParser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author asmith
 */
@Service("publisherValueParser")
public class PublisherValueParser implements MultiValueParser<Publisher> {

    @Override
    public List<Publisher> parseValue(String value) {
        List<Publisher> publishersToReturn = new ArrayList<>();
        String[] receivedPublishers = value.split("/");

        Publisher p;

        for (String dev : receivedPublishers) {
            p = new Publisher();
            p.setName(dev);
            publishersToReturn.add(p);
        }

        return publishersToReturn;
    }

}
