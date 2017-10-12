package com.asmith.right.rate.domain.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author asmith
 */
@Entity
@NamedQueries({
    @NamedQuery(
            name = "findPublisherByName",
            query = "Select p FROM Publisher AS p WHERE p.name = :name"
    )
})
public class Publisher extends Creator implements Serializable {

    public Publisher() {
    }

    public Publisher(String name, String url) {
        super(name, url);
    }

    @Override
    public String toString() {
        return "Publisher{" + "name=" + name + ", url=" + url + '}';
    }

}
