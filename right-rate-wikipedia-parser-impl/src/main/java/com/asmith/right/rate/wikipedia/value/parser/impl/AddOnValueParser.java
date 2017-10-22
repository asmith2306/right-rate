package com.asmith.right.rate.wikipedia.value.parser.impl;

import com.asmith.right.rate.domain.constants.AddOn;
import com.asmith.right.rate.domain.constants.Xclusivity;
import com.asmith.wikipedia.parser.api.MultiValueParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

/**
 * @author asmith
 */
@Service("addOnValueParser")
public class AddOnValueParser implements MultiValueParser<AddOn> {

    private Map<String, AddOn> mappings;

    @Override
    public List<AddOn> parseValue(String value) {
        List<AddOn> addonsToReturn = new ArrayList<>();
        // the addon value from the wiki table returns non ascii chars, so split on them
        List<String> split = Arrays.asList(value.split("[^\\\\x00-\\\\x7F]")); // 0 - 127
        split.stream().filter(s -> s.length() > 0).forEach(addOn -> {
            if (null != mappings.get(addOn)) {
                addonsToReturn.add(mappings.get(addOn));
            }
        });
        return addonsToReturn;
    }

    @PostConstruct
    public void init() {
        mappings = new HashMap<>();
        mappings.put("3D", AddOn.ThreeD);
        mappings.put("PC", AddOn.CROSS_PLAY);
        mappings.put("PS3", AddOn.CROSS_PLAY);
        mappings.put("Vita", AddOn.CROSS_PLAY);
        mappings.put("C", AddOn.CAMERA);
        mappings.put("HDR", AddOn.HDR);
        mappings.put("M", AddOn.MOVE);
        mappings.put("P", AddOn.PRO);
        mappings.put("VR", AddOn.VR);
    }

}
