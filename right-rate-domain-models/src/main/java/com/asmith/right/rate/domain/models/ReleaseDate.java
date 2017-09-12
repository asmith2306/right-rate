package com.asmith.right.rate.domain.models;

/**
 * @author asmith
 */
public class ReleaseDate {

    private final String euReleaseDate;
    private final String jpReleaseDate;
    private final String naReleaseDate;

    public ReleaseDate(String eu, String jp, String na) {
        this.euReleaseDate = eu;
        this.jpReleaseDate = jp;
        this.naReleaseDate = na;
    }

}
