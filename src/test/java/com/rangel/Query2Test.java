package com.rangel;

import static java.util.Collections.emptySet;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Query2Test {

    @Test
    @DisplayName("Query 2 - querying based on an empty collection must return an empty list")
    public void queryBasedOnAnEmptyCollection() {
        testQuery(emptySet(), "Malcolm D. Lee", emptyList());
    }

    private static void testQuery(
        Collection<Movie> movies,
        String ditector,
        List<String> expectedOutput
    ) {
        Queries queries = new Queries(movies);

        List<String> actualOutput = queries.ActorsWhoActedInDirectorsMoviesAlphabetically(ditector);

        assertEquals(expectedOutput, actualOutput);
    }
}
