package com.asmith.right.rate.domain.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author asmith
 */
@Entity
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String score;
    private String url;
    private String reviewer;
    private String snippet;

    @ManyToOne(fetch = FetchType.LAZY)
    private Game game;

    public Review(String score, String url, String reviewer, String snippet) {
        this.score = score;
        this.url = url;
        this.reviewer = reviewer;
        this.snippet = snippet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "Review{" + "id=" + id + ", score=" + score + ", url=" + url + ", reviewer=" + reviewer + ", snippet=" + snippet + ", game=" + game.getName() + '}';
    }

}
