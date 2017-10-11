package com.asmith.right.rate.wikipedia.value.parser.impl;

import com.asmith.right.rate.domain.constants.Genre;
import com.asmith.wikipedia.parser.api.ValueParser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author asmith
 */
@Service
public class GenreVauleParserImpl implements ValueParser<List<Genre>> {

    @Override
    public List<Genre> parseValue(String value) {
        List<Genre> genresToReturn = new ArrayList<>();
        String[] receivedGenres = value.split(",");

        for (String genre : receivedGenres) {
            for (Genre supportedGenre : Genre.values()) {
                if (genre.toUpperCase().replace("-", "").contains(supportedGenre.name())) {
                    genresToReturn.add(supportedGenre);
                }
            }
        }

        return genresToReturn;
    }

}
