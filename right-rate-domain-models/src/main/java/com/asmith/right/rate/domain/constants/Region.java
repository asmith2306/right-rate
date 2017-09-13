package com.asmith.right.rate.domain.constants;

/**
 * @author asmith
 */
public enum Region {
    NA("North America"),
    JP("Japan"),
    EU("EU");

    private final String name;

    Region(String name) {
        this.name = name;
    }
}
