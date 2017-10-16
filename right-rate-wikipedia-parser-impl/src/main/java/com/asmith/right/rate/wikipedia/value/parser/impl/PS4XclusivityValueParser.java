package com.asmith.right.rate.wikipedia.value.parser.impl;

import com.asmith.right.rate.domain.constants.Xclusivity;
import com.asmith.wikipedia.parser.api.XclusivityParser;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

/**
 * @author asmith
 */
@Service("ps4XclusivityValueParser")
public class PS4XclusivityValueParser implements XclusivityParser<Xclusivity> {

    private Map<String, Xclusivity> mappings;

    @Override
    public Xclusivity parseExclusivity(String value) {
        return mappings.get(value);
    }

    @PostConstruct
    public void init() {
        mappings = new HashMap<>();
        mappings.put("Yes", Xclusivity.PLAYSTATION);
        mappings.put("Sony", Xclusivity.PLAYSTATION);
        mappings.put("Console", Xclusivity.MULTIPLAT);
        mappings.put("Timed", Xclusivity.MULTIPLAT);
        mappings.put("No", Xclusivity.MULTIPLAT);
    }

}
