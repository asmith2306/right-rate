package com.asmith.right.rate.wikipedia.value.parser.impl;

import com.asmith.right.rate.domain.constants.Xclusivity;
import com.asmith.wikipedia.parser.api.ValueParser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author asmith
 */
@Service("platformValueParser")
public class XclusivityValueParserImpl implements ValueParser<Xclusivity> {

    @Override
    public List<Xclusivity> parseValue(String value) {
        List<Xclusivity> xclusivityToReturn = new ArrayList<>();

        return xclusivityToReturn;
    }

}
