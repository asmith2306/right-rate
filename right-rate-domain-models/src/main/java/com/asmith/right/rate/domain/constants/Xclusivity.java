package com.asmith.right.rate.domain.constants;

/**
 * @author asmith
 */
public enum Xclusivity {
    PLAYSTATION("PlayStation"), MICROSOFT("Microsoft"), NINTENDO("Nintendo"), PC("PC"), MULTIPLAT("MultiPlat");
    private final String description;

    private Xclusivity(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}
