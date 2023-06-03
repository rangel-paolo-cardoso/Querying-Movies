package com.rangel;

import static java.util.Collections.emptySet;

import java.util.AbstractMap;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Queries {

    private final Collection<Movie> movies;

    public Queries(Collection<Movie> movies) {
        this.movies = movies;
    }

    /**
    * Query 1: from the movies collection in this class, this method returns the set 
    * of actors who played themselves in at least one of these movies.
    *
    * <p>It is considered that "actors who played themselves" those who have their names as a key 
    * on the Map `actorsPerCharacter` and also as one of the items belonging to the set 
    * associated with this same key.</p>
    */
    public Set<String> actorsWhoPlayedThemselves() {
        Set<String> actors = movies.stream()
                .flatMap(movie -> movie.actors.stream())
                .collect(Collectors.toSet());

        return movies.stream()
                .flatMap(movie -> movie.actorsPerCharacter.keySet().stream())
                .filter(actor -> actors.contains(actor))
                .collect(Collectors.toSet());
    }

    /**
    * Query 2: from the movies collection in this class, this method returns a list of actors 
    * who played in at least one movie of a particular director. The list returned must be
    * in alphabetical order.
    *
    * <p>It is considered that an actor has played in a certain movie of a certain director if they have their
    * names as one of the items on the field `actors` as well as the director in this case 
    * has their names as one of the items on the field `directors` in the same movies.</p>
    */
    public List<String> ActorsWhoActedInDirectorsMoviesAlphabetically(String director) {
        return movies.stream()
                .filter(movie -> movie.directors.contains(director))
                .flatMap(movie -> movie.actors.stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    /**
    * Query 3: from the movies collection in this class, this method returns the list of movies 
    * in which at least one of the directors has played. The returned list must be arranged in order of 
    * release, with the most recent movies at the beginning.
    *
    * <p>It is considered that "movies in which at least one director has played" are those in which 
    * at least one of the items on the field `directors` is also an item on the field campo `actors`.</p>
    */
    public List<Movie> moviesInWhichAtLeastOneDirectorActedMostRecentFirst() {
        return movies.stream()
                .filter(movie -> movie.directors.stream()
                        .anyMatch(director -> movie.actors.contains(director)))
                .distinct()
                .sorted((m1, m2) -> m2.releaseYear - m1.releaseYear)
                .collect(Collectors.toList());
    }

    /**
    * Query 4: from the movies collection in this class, this method returns a Map containing 
    * all the movies released in a particular year are grouped by category.
    *
    * <p>Each key on the Map represents a category, whereas each value represents the 
    * set of movies that fit the category of the correspondent key.</p>
    */
    public Map<String, Set<Movie>> moviesReleasedInTheYearGroupedByCategory(int year) {
        return movies.stream()
                .filter(movie -> movie.releaseYear == year)
                .flatMap(movie -> movie.categories.stream()
                        .map(category -> new AbstractMap.SimpleEntry<>(category, movie)))
                .collect(
                        Collectors.groupingBy(AbstractMap.SimpleEntry::getKey,
                                Collectors.mapping(AbstractMap.SimpleEntry::getValue, Collectors.toSet())));
    }
}
