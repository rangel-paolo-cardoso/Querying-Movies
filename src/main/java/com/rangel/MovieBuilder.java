package com.rangel;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MovieBuilder {

    private final String title;
    private final int releaseYear;
    private final Set<String> categories = new HashSet<>();
    private final Set<String> directors = new HashSet<>();
    private final Map<String, Set<String>> actorsPerCharacter = new HashMap<>();

    public MovieBuilder(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public Movie build() {
        return new Movie(title, releaseYear, categories, directors, actorsPerCharacter);
    }

    public MovieBuilder categories(String... tags) {
        Collections.addAll(this.categories, tags);
        return this;
    }

    public MovieBuilder directors(String... directors) {
        Collections.addAll(this.directors, directors);
        return this;
    }

    public MovieBuilder character(String character, String... actors) {
        actorsPerCharacter.put(character, Set.of(actors));
        return this;
    }
}
