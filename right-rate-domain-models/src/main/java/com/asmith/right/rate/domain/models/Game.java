package com.asmith.right.rate.domain.models;

import com.asmith.right.rate.domain.constants.Exclusive;
import com.asmith.right.rate.domain.constants.Genre;
import java.io.Serializable;
import java.util.List;

/**
 * @author asmith
 */
public class Game implements Serializable {

    private Long Id;
    private String name;
    private List<Genre> genres;
    private List<Developer> developers;
    private List<Publisher> publishers;
    private List<Exclusive> exclusives;
}
