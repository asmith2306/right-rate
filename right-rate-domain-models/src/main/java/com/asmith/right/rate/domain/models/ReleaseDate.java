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
    private LocalDate releaseDate;

    public ReleaseDate() {
    }

    public ReleaseDate(Region region, LocalDate releaseDate) {
        this.region = region;
        this.releaseDate = releaseDate;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public LocalDate getDate() {
        return releaseDate;
    }

    public void setDate(LocalDate date) {
        this.releaseDate = date;
    }

    @Override
    public String toString() {
        return "ReleaseDate{" + "region=" + region + ", releaseDate=" + releaseDate + '}';
    }

}
