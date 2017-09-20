package com.asmith.right.rate.domain.models;

import com.asmith.right.rate.domain.constants.Platform;
import com.asmith.right.rate.domain.constants.Genre;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author asmith
 */
@Entity
@NamedQueries({
    @NamedQuery(
            name = "findGamesByGenre",
            query = "SELECT g FROM Game AS g WHERE :genre MEMBER OF g.genres"
    )
    ,
    @NamedQuery(
            name = "findGamesByPlatform",
            query = "SELECT g FROM Game AS g WHERE :platform MEMBER OF g.platforms"
                    + " AND size (g.platforms) = 1"
    )
    ,
    @NamedQuery(
            name = "findMultiPlatGames",
            query = "SELECT g FROM Game AS g WHERE size (g.platforms) > 1"
    )
    ,
    @NamedQuery(
            name = "findGamesByDeveloper",
            query = "SELECT g FROM Game AS g WHERE :developer MEMBER OF g.developers"
    )
    ,
    @NamedQuery(
            name = "findGamesByPublisher",
            query = "SELECT g FROM Game AS g WHERE :publisher MEMBER OF g.publishers"
    )
})
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long Id;
    protected String name;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    protected List<Genre> genres = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST})
    protected List<Developer> developers = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST})
    protected List<Publisher> publishers = new ArrayList<>();

    @ElementCollection
    @Enumerated(EnumType.STRING)
    protected List<Platform> platforms = new ArrayList<>();

    @ElementCollection
    @Enumerated(EnumType.STRING)
    protected List<ReleaseDate> releaseDates = new ArrayList<>();

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

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void addDeveloper(Developer developer) {
        this.developers.add(developer);
        developer.addGame(this);
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void addPublisher(Publisher publisher) {
        this.publishers.add(publisher);
        publisher.addGame(this);
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void addPlatform(Platform platform) {
        this.platforms.add(platform);
    }

    public List<ReleaseDate> getReleaseDates() {
        return releaseDates;
    }

    public void addReleaseDate(ReleaseDate releaseDate) {
        this.releaseDates.add(releaseDate);
    }

    @Override
    public String toString() {
        return "Game{" + "Id=" + Id + ", name=" + name + ", genres=" + genres + ", developers=" + developers + ", publishers=" + publishers + ", platforms=" + platforms + ", releaseDates=" + releaseDates + '}';
    }

}
