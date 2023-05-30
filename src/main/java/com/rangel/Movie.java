package com.rangel;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Movie {

    public final String title;
    public final int releaseYear;
    public final Set<String> categories;
    public final Set<String> directors;
    public final Set<String> actors;
    public final Set<String> characters;
    public final Map<String, Set<String>> actorsPerCharacter;

    public Movie(
            String title,
            int releaseYear,
            Set<String> categories,
            Set<String> directors,
            Set<String> actors,
            Set<String> characters,
            Map<String, Set<String>> actorsPerCharacter) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.categories = Set.copyOf(categories);
        this.directors = Set.copyOf(directors);
        this.actorsPerCharacter = Collections.unmodifiableMap(actorsPerCharacter);

        this.characters = Collections.unmodifiableSet(actorsPerCharacter.keySet());
        this.actors = actorsPerCharacter.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", title, releaseYear);
    }
}
