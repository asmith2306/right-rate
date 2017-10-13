package com.asmith.right.rate.domain.models;

import java.time.LocalDate;
import com.asmith.right.rate.domain.constants.Region;
import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author asmith
 */
@Embeddable
public class ReleaseDate implements Serializable {

    @Enumerated(EnumType.STRING)
    private Region region;
    private String date;

    public ReleaseDate() {
    }

    public ReleaseDate(Region region, String date) {
        this.region = region;
        this.date = date;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ReleaseDate{" + "region=" + region + ", date=" + date + '}';
    }

}
