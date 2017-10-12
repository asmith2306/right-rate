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
            name = "findDeveloperByName",
            query = "Select d FROM Developer AS d WHERE d.name = :name"
    )
})
public class Developer extends Creator implements Serializable {

    public Developer() {
    }

    public Developer(String name, String url) {
        super(name, url);
    }

    @Override
    public String toString() {
        return "Developer{" + "name=" + name + ", url=" + url + '}';
    }

}
