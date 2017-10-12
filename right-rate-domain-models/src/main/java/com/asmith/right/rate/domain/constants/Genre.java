package com.asmith.right.rate.domain.constants;

/**
 * @author asmith
 */
public enum Genre {
    PLATFORM("Platform"), SHOOTER("Shooter"), FIGHTING("Fighting"),
    STEALTH("Stealth"), SURVIVAL("Survival"), HORROR("Horror"),
    PUZZLE("Puzzle"), ADVENTURE("Adventure"), STRATEGY("Strategy"),
    RPG("RPG"), FANTASY("Fantasy"), SCIFI("Sci-Fi"),
    SPORTS("Sports"), SPORT("Sport"),
    SIMULATION("Simulation"), RACING("Racing"), PARTY("Party"),
    MMO("MMO"), ACTION("Action"), TURNBASED("Turn Based");
    private final String description;

    Genre(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}
