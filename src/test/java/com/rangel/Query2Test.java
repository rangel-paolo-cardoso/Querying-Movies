package com.rangel;

import static java.util.Collections.emptySet;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Query2Test {

    @Test
    @DisplayName("Query 2 - querying based on an empty collection must return an empty list")
    public void queryBasedOnAnEmptyCollection() {
        testQuery(emptySet(), "Malcolm D. Lee", emptyList());
    }

    @Test
    @DisplayName("Query 2 - the query must return an empty list when no actor fulfills the requirement")
    public void noActorFulfillsTheRequirement() {
        testQuery(Movies.all(), "(director not included)", emptyList());
    }

    @Test
    @DisplayName("Query 2 - the query must return the correct results in the correct order")
    public void aFewActorsFulfillTheRequirement() {
        testQuery(
                Movies.all(),
                "Quentin Tarantino",
                List.of(
                        "Brad Pitt",
                        "Bruce Willis",
                        "Christoph Waltz",
                        "Diane Kruger",
                        "Eli Roth",
                        "Harvey Keitel",
                        "Jamie Foxx",
                        "John Travolta",
                        "Kerry Washington",
                        "Leonardo DiCaprio",
                        "Michael Fassbender",
                        "Mélanie Laurent",
                        "Samuel L. Jackson",
                        "Uma Thurman",
                        "Ving Rhames"));
    }

    @Test
    @DisplayName("Query 2 - no actor must appear more than once on the result list")
    public void noDuplicateItems() {
        Set<Movie> movies = Set.of(Movies.pulpFiction, Movies.djangoUnchained);
        Queries queries = new Queries(movies);
        List<String> results = queries.ActorsWhoActedInDirectorsMoviesAlphabetically("Quentin Tarantino");

        long countingSamuelJackson = results.stream()
                .filter(actor -> actor.equals("Samuel L. Jackson"))
                .count();
    }

    private static void testQuery(
            Collection<Movie> movies,
            String ditector,
            List<String> expectedOutput) {
        Queries queries = new Queries(movies);

        List<String> actualOutput = queries.ActorsWhoActedInDirectorsMoviesAlphabetically(ditector);

        assertEquals(expectedOutput, actualOutput);
    }
}
