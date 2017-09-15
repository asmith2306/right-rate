package com.asmith.right.rate.domain.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author asmith
 */
@Entity
@DiscriminatorValue("PS4_GAME")
@NamedQueries({
    @NamedQuery(
            name = "findPS4GamesByGenre",
            query = "SELECT game FROM PS4Game AS game WHERE :genre MEMBER OF game.genres"
    ),
    @NamedQuery(
            name = "findPS4GamesByDeveloper",
            query = "SELECT game FROM PS4Game AS game WHERE :developer MEMBER OF game.developers"
    ),
    @NamedQuery(
            name = "findPS4GamesByPublisher",
            query = "SELECT game FROM PS4Game AS game WHERE :publisher MEMBER OF game.publishers"
    )
})
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
