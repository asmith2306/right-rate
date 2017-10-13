package com.asmith.right.rate.domain.models;

import com.asmith.right.rate.domain.constants.Genre;
import com.asmith.right.rate.domain.constants.Xclusivity;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * @author asmith
 */
@Entity
@NamedQueries({
    @NamedQuery(
            name = "findGamesByGenre",
            query = "SELECT g FROM Game AS g WHERE :genre MEMBER OF g.genres"
    ),
    @NamedQuery(
            name = "findGamesByExclusivity",
            query = "SELECT g FROM Game AS g WHERE g.exclusivity = :exclusivity"
    ),
    @NamedQuery(
            name = "findGamesByDeveloper",
            query = "SELECT g FROM Game g JOIN g.developers d WHERE d.name = :name"
    ),
    @NamedQuery(
            name = "findGamesByPublisher",
            query = "SELECT g FROM Game g JOIN g.publishers p WHERE p.name = :name"
    )
})
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Genre> genres = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST}) //cascade will remove the need to persist the developers manually when persisting games
    @JoinTable( // required on many to many in inheritance scenarios, but useful to specify details of the join table anyways if not
            name = "GAMES_TO_DEVELOPERS",
            joinColumns = @JoinColumn(name = "GAME_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "DEVELOPER_ID", referencedColumnName = "ID")
    )
    private List<Developer> developers = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable( // required on many to many in inheritance scenarios, but useful to specify details of the join table anyways if not
            name = "GAMES_TO_PUBLISHERS",
            joinColumns = @JoinColumn(name = "GAME_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PUBLISHER_ID", referencedColumnName = "ID")
    )
    private List<Publisher> publishers = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Xclusivity exclusivity;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<ReleaseDate> releaseDates = new ArrayList<>();

    @OneToMany(mappedBy = "game", cascade = {CascadeType.PERSIST})
    private List<Review> reviews = new ArrayList<>();

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

    public List<Genre> setGenres(List<Genre> genres) {
        this.genres = genres;
        return this.genres;
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public List<Developer> setDevelopers(List<Developer> developers) {
        this.developers = developers;
        return this.developers;
    }

    public void addDeveloper(Developer developer) {
        this.developers.add(developer);
        developer.addGame(this);
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public List<Publisher> setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
        return this.publishers;
    }

    public void addPublisher(Publisher publisher) {
        this.publishers.add(publisher);
        publisher.addGame(this);
    }

    public Xclusivity getExclusivity() {
        return exclusivity;
    }

    public void setExclusivity(Xclusivity exclusivity) {
        this.exclusivity = exclusivity;
    }

    public List<ReleaseDate> getReleaseDates() {
        return releaseDates;
    }

    public void setReleaseDates(List<ReleaseDate> releaseDates) {
        this.releaseDates = releaseDates;
    }
    
    public void addReleaseDate(ReleaseDate releaseDate) {
        this.releaseDates.add(releaseDate);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
        review.setGame(this);
    }

    @Override
    public String toString() {
        return "Game{" + "Id=" + Id + ", name=" + name + ", genres=" + genres + ", developers=" + developers + ", publishers=" + publishers + ", exclusivity=" + exclusivity + ", releaseDates=" + releaseDates + '}';
    }

}
