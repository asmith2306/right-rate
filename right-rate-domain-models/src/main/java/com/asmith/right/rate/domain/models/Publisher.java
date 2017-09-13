package com.asmith.right.rate.domain.models;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * @author asmith
 */
@Embeddable
public class Publisher implements Serializable {

    private String name;
    private String url;

    public Publisher() {
    }

    public Publisher(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Publisher{" + "name=" + name + ", url=" + url + '}';
    }
    
}
