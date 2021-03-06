package com.asmith.right.rate.wikipedia.value.parser.impl;

import com.asmith.right.rate.domain.models.Developer;
import com.asmith.wikipedia.parser.api.MultiValueParser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author asmith
 */
@Service("developerValueParser")
public class DeveloperValueParser implements MultiValueParser<Developer> {

    @Override
    public List<Developer> parseValue(String value) {
        List<Developer> developersToReturn = new ArrayList<>();
        String[] receivedDevelopers = value.split("/");

        Developer d;

        for (String dev : receivedDevelopers) {
            d = new Developer();
            d.setName(dev.trim());
            developersToReturn.add(d);
        }

        return developersToReturn;
    }

}
