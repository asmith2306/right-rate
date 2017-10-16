package com.asmith.right.rate.wikipedia.value.parser.impl;

import com.asmith.right.rate.domain.constants.Addon;
import com.asmith.wikipedia.parser.api.MultiValueParser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author asmith
 */
@Service("addOnValueParserImpl")
public class AddonValueParserImpl implements MultiValueParser<Addon> {

    @Override
    public List<Addon> parseValue(String value) {
        String s = value.replaceAll("\\s+","");
        System.out.println(s);
        List<Addon> addonsToReturn = new ArrayList<>();
       
        return addonsToReturn;
    }

}
