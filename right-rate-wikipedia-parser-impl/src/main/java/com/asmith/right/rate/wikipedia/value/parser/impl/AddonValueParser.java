package com.asmith.right.rate.wikipedia.value.parser.impl;

import com.asmith.right.rate.domain.constants.Addon;
import com.asmith.wikipedia.parser.api.MultiValueParser;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 * @author asmith
 */
@Service("addOnValueParser")
public class AddonValueParser implements MultiValueParser<Addon> {

    @Override
    public List<Addon> parseValue(String value) {
        List<Addon> addonsToReturn = new ArrayList<>();
        // the addon value from the wiki table returns non ascii chars, so split on them
        String[] split = value.split("[^\\\\x00-\\\\x7F]"); // 0 - 127
        for (String s : split) {
            System.out.println(s.trim());
        }
        return addonsToReturn;
    }

}
