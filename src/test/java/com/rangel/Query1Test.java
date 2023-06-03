package com.rangel;

import static java.util.Collections.emptySet;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Query1Test {

    @Test
    @DisplayName("Query 1 - querying based on an empty collection must return an empty set")
    public void queryBasedOnAnEmptyCollection() {
        testQuery(emptySet(), emptySet());
    }

    @Test
    @DisplayName("Query 1 - the query must return an empty set when no actor fulfills the requirement")
    public void noActorFulfillsTheRequirement() {
        testQuery(
                Set.of(Movies.avengersEndgame, Movies.matrixResurrections, Movies.inglouriousBasterds),
                emptySet());
    }

    @Test
    @DisplayName("Query 1 - the query must return the correct results")
    public void aFActorsFulfillTheRequirement() {
        testQuery(
                Movies.all(),
                Set.of("LeBron James", "John Malkovich"));
    }

    private static void testQuery(Collection<Movie> movies, Set<String> expectedOutput) {
        Queries queries = new Queries(movies);
        Set<String> actualOutput = queries.actorsWhoPlayedThemselves();
        assertEquals(expectedOutput, actualOutput);
    }
}
