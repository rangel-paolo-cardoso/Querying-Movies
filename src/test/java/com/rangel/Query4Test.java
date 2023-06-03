package com.rangel;

import static java.util.Collections.emptyMap;
import static java.util.Collections.emptySet;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Query4Test {

    @Test
    @DisplayName("Query 4 - querying based on an empty collection must return an empty mep")
    public void queryBasedOnAnEmptyCollection() {
        testQuery(emptySet(), 2021, emptyMap());
    }

    @Test
    @DisplayName("Query 4 - the query must return an empty map when n movie fulfills the requirement")
    public void noMovieFulfillsTheRequirement() {
        testQuery(
                Set.of(Movies.braveheart, Movies.inglouriousBasterds, Movies.avengersEndgame),
                2021,
                emptyMap());
    }

    @Test
    @DisplayName("Query 4 - the query must return the correct results")
    public void aFewMoviesFulfillTheRequirement() {
        testQuery(
                Movies.all(),
                2021,
                Map.of(
                        "SiFi", Set.of(
                                Movies.dontLookUp,
                                Movies.matrixResurrections,
                                Movies.spiderManNoWayHome,
                                Movies.spaceJam2021),
                        "Comedy", Set.of(
                                Movies.dontLookUp,
                                Movies.spaceJam2021),
                        "Action", Set.of(
                                Movies.matrixResurrections,
                                Movies.spiderManNoWayHome),
                        "Drama", Set.of(
                                Movies.dontLookUp),
                        "Animation", Set.of(
                                Movies.spaceJam2021),
                        "Adventure", Set.of(
                                Movies.matrixResurrections,
                                Movies.spiderManNoWayHome),
                        "Family", Set.of(
                                Movies.spaceJam2021)));
    }

    @Test
    @DisplayName("Query 4 - a movie that fulfills the requirements and belongs to more than one category must appear"
            + " em todas elas")
    public void multiplasCategorias() {
        Set<Movie> movies = Set.of(Movies.spiderManNoWayHome);
        Queries queries = new Queries(movies);
        Map<String, Set<Movie>> atualOutput = queries.moviesReleasedInTheYearGroupedByCategory(2021);

        Map<String, Set<Movie>> expectedOutput = Map.of(
                "Action", Set.of(Movies.spiderManNoWayHome),
                "Adventure", Set.of(Movies.spiderManNoWayHome),
                "SiFi", Set.of(Movies.spiderManNoWayHome));

        assertEquals(expectedOutput, atualOutput);
    }

    private void testQuery(
            Collection<Movie> movies,
            int releaseYear,
            Map<String, Set<Movie>> expectedOutput) {
        Queries queries = new Queries(movies);

        Map<String, Set<Movie>> actualOutput = queries.moviesReleasedInTheYearGroupedByCategory(releaseYear);

        assertEquals(expectedOutput, actualOutput);
    }
}
