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

    private void testQuery(
        Collection<Movie> movies,
        int releaseYear,
        Map<String, Set<Movie>> expectedOutput
    ) {
        Queries queries = new Queries(movies);

        Map<String, Set<Movie>> actualOutput = queries.moviesReleasedInTheYearGroupedByCategory(releaseYear);

        assertEquals(expectedOutput, actualOutput);
    }
}
