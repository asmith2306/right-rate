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
        System.out.println(value.replaceAll("\\s+",""));
        
        List<Addon> addonsToReturn = new ArrayList<>();
        String[] split = value.split("");
        for (String s : split) {
            System.out.println(s.trim());
        }
        return addonsToReturn;
    }

}
