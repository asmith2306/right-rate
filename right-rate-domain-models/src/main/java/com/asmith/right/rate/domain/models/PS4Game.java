package com.asmith.right.rate.domain.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 * @author asmith
 */
@Entity
@NamedQuery(
        name = "findPS4GameByGenre",
        query = "SELECT game FROM PS4Game AS game WHERE :genre MEMBER OF game.genres"
)
public class PS4Game extends Game {

    @ElementCollection
    private List<String> addOns;

    public List<String> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<String> addOns) {
        this.addOns = addOns;
    }

    public void addAddOn(String addOn) {
        if (null == this.addOns) {
            this.addOns = new ArrayList<>();
            this.addOns.add(addOn);
        } else {
            this.addOns.add(addOn);
        }
    }

    @Override
    public String toString() {
        return super.toString() + addOns.toString();
    }

}
