package com.rangel;

import static java.util.Collections.emptySet;

import java.util.Collection;
import java.util.Set;

public class Queries {

    private final Collection<Movie> movies;

    public Queries(Collection<Movie> movies) {
        this.movies = movies;
    }

    /**
    * Query 1: from the movies collection in this class, this method returns the set 
    * of actors who played themselves in at least one of these movies.
    *
    * It is considered that "actors who played themselves" those who have their names as a key 
    * on the Map `actorsPerCharacter` and also as one of the items belonging to the set 
    * associated with this same key.</p>
    */
    public Set<String> actorsWhoPlayedThemselves() {
        return emptySet(); // TODO: Implement.
    }
}
