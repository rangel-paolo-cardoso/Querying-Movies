package com.rangel;

import static java.util.Collections.emptySet;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Query3Test {

    @Test
    @DisplayName("Query 3 - querying based on an empty collection must return an empty list")
    public void queryingBasedOnAnEmptyCollection() {
        testQuery(emptySet(), emptyList());
    }

    @Test
    @DisplayName("Query 3 - the query must return an empty list when no movie fulfills the requirement")
    public void noMovieFulfillsTheRequirement() {
        testQuery(
                Set.of(Movies.spaceJam2021, Movies.spiderManNoWayHome, Movies.djangoUnchained),
                emptyList());
    }

    @Test
    @DisplayName("Query 3 - the query must return the correct result in the correct order")
    public void aFewMoviesFulfillTheRequirement() {
        testQuery(
                Movies.all(),
                List.of(Movies.rockyII, Movies.braveheart, Movies.theGreatDictator));
    }

    @Test
    @DisplayName("Query 3 - no movies must appear more than once on the result list")
    public void noDuplicateItems() {
        List<Movie> movies = List.of(Movies.braveheart, Movies.braveheart);
        Queries queries = new Queries(movies);
        List<Movie> results = queries.moviesInWhichAtLeastOneDirectorActedMostRecentFirst();

        long countingBraveHeart = results.stream()
                .filter(movie -> movie.equals(Movies.braveheart))
                .count();
    }

    private static void testQuery(Collection<Movie> movies, List<Movie> expectedOutput) {
        Queries queries = new Queries(movies);
        List<Movie> actualOutput = queries.moviesInWhichAtLeastOneDirectorActedMostRecentFirst();
        assertEquals(expectedOutput, actualOutput);
    }
}
