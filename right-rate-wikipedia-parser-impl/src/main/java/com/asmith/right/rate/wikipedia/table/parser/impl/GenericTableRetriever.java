package com.asmith.right.rate.wikipedia.table.parser.impl;

import com.asmith.wikipedia.parser.api.TableRetriever;
import com.asmith.wikipedia.parser.api.params.TableDetails;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

/**
 * @author asmith
 */
@Service
public class GenericTableRetriever implements TableRetriever<Element> {

    @Override
    public Element getTableById(TableDetails details) {
        try {
            System.out.println("Retrieving table by Id with details: " + details);
            return Jsoup.connect(details.getTablePage()).maxBodySize(0).get().getElementById(details.getTableIdentifier());
        } catch (IOException ex) {
            Logger.getLogger(AbstractGameTableParser.class.getName()).log(Level.WARNING, null, ex);
            return null;
        }
    }

    @Override
    public List<Element> getTablesByClass(TableDetails details) {
        try {
            System.out.println("Retrieving table by class with details: " + details);
            return Jsoup.connect(details.getTablePage()).maxBodySize(0).get().select("table[class=" + details.getTableIdentifier() + "]");
        } catch (IOException ex) {
            Logger.getLogger(AbstractGameTableParser.class.getName()).log(Level.WARNING, null, ex);
            return new ArrayList<>();
        }
    }

}
