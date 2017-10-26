package com.asmith.wikipedia.parser.api;

import com.asmith.wikipedia.parser.api.params.TableDetails;
import java.util.List;

/**
 * @author asmith
 */
public interface TableRetriever<T> {

    T getTableById(TableDetails details);

    List<T> getTablesByClass(TableDetails details);

}
