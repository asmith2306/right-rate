package com.asmith.right.rate.domain.models;

import com.asmith.right.rate.domain.constants.Exclusive;
import com.asmith.right.rate.domain.constants.Genre;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author asmith
 */
@Entity
@Inheritance
@DiscriminatorColumn(name="GAME_TYPE")
@Table(name="GAME")
public abstract class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long Id;
    protected String name;
    
    @ElementCollection
    @Enumerated(EnumType.STRING)
    protected List<Genre> genres;
    
    @ManyToMany
    protected List<Developer> developers;

    @ManyToMany
    protected List<Publisher> publishers;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    protected List<Exclusive> exclusives;
    
    @ElementCollection
    @Enumerated(EnumType.STRING)
    protected List<ReleaseDate> releaseDates;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void addGenre(Genre genre) {
        if (null == this.genres) {
            this.genres = new ArrayList<>();
            this.genres.add(genre);
        } else {
            this.genres.add(genre);
        }
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public void addDeveloper(Developer developer) {
        if (null == this.developers) {
            this.developers = new ArrayList<>();
            this.developers.add(developer);
        } else {
            this.developers.add(developer);
        }
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    public void addPublisher(Publisher publisher) {
        if (null == this.publishers) {
            this.publishers = new ArrayList<>();
            this.publishers.add(publisher);
        } else {
            this.publishers.add(publisher);
        }
    }

    public List<Exclusive> getExclusives() {
        return exclusives;
    }

    public void setExclusives(List<Exclusive> exclusives) {
        this.exclusives = exclusives;
    }

    public void addExclusive(Exclusive exclusive) {
        if (null == this.exclusives) {
            this.exclusives = new ArrayList<>();
            this.exclusives.add(exclusive);
        } else {
            this.exclusives.add(exclusive);
        }
    }

    public List<ReleaseDate> getReleaseDates() {
        return releaseDates;
    }

    public void setReleaseDates(List<ReleaseDate> releaseDates) {
        this.releaseDates = releaseDates;
    }

    public void addReleaseDate(ReleaseDate releaseDate) {
        if (null == this.releaseDates) {
            this.releaseDates = new ArrayList<>();
            this.releaseDates.add(releaseDate);
        } else {
            this.releaseDates.add(releaseDate);
        }
    }

    @Override
    public String toString() {
        return "Game{" + "Id=" + Id + ", name=" + name + ", genres=" + genres + ", developers=" + developers + ", publishers=" + publishers + ", exclusives=" + exclusives + ", releaseDates=" + releaseDates + '}';
    }

}
