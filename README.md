# Challenge requirements

## Querying movies

This challenge is for those who like cinema (and manipulating lists in Java from time to time 🤪)!

We have a class representing a very simply movie:

```java
import java.util.Map;
import java.util.Set;

public class Movie {

  public final String title;
  public final int releaseYear;
  public final Set<String> categories;
  public final Set<String> directors;
  public final Set<String> actors;
  public final Set<String> characters;
  public final Map<String, Set<String>> actorsPerCharacter;

  // ...
}
```

The `categories`, `directors`, `actors` and `characters` fields are all sets of Strings because each of them can have multiple values. For example, a movie can fit into multiple categories (action, comedy, etc.) and it can also have more than one director (in some Marvel movies, the Russo brothers, Joe and Anthony, for example).

The `actorsPerCharacter` field is a Map that associates the name of a character (`String`) to a set of actors (`Set<String>`). For example, in Space Jam (2021), the character LeBron James is played by the NBA player himself in his adult phase, but is also played younger by actor Stephen Kankole.

Your goal is to implement a class that performs the following queries on a given collection of movies:

1. Actors who played themselves.
2. Actors who acted in films by a certain director, in alphabetical order.
3. Movies in which the director acted (or at least one of them), in order of release (most recent first).
4. [Bonus] Movies released in a given year, grouped by category.

Observações:

- "Actors who played themselves" refers to actors who, in at least one movie, have their name as one of the keys of the Map `actorsPerCharacter` and also as one of the items belonging to the set associated with this same key.

- "Actors who acted in movies by a certain director" refers to actors who, in at least one movie, have their name as one of the items in the `actors` field, at the same time that the director in question has their name as one of the items in the `directors` field.

- "Movies in which the director acted (or at least one of them)" refers to films in which at least one of the items in the `directors` field is also an item in the `actors` field.

## Code requirements

You must program the `Queries` class from the following model:

- `Queries.java`
```java
import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static java.util.Collections.emptySet;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Queries {

  private final Collection<Movie> movies;

  public Consultas(Collection<Movie> movies) {
    this.movies = movies;
  }

  public Set<String> actorsWhoPlayedThemselves() {
    return emptySet(); // TODO: Implement.
  }

  public List<String> ActorsWhoActedInDirectorsMoviesAlphabetically(String director) {
    return emptyList(); // TODO: Implement.
  }

  public List<Movie> moviesInWhichAtLeastOneDirectorActedMostRecentFirst() {
    return emptyList(); // TODO: Implement.
  }

  public Map<String, Set<Movie>> moviesReleasedInTheYearGroupedByCategory(int year) {
    return emptyMap(); // TODO: Implement (bônus).
  }
}
```

Each method is equivalent to one of the queries. Each method must return data obtained from the `movies` attribute that belongs to the class, meeting the requirement of each query. Notice the returned types:

- The first query returns a `Set<>`, as the results do not have a defined order.
- The second query returns `List<>`, as the results are arranged in alphabetical order.
- The third query returns `List<>`, as the results are arranged in order of release.
- The fourth query returns a `Map<String, Set<Movie>>`. The keys (`String`) of the Map represent a category, while the values (`Set<Movie>`) represent the set of movies that fit that category.

⚠️ **Important!** You should never return `null`. If none of the items meet the query requirements, return an empty collection (Set, List, or Map).

You should also pay attention to the possibility of an item being included more than once in the returned collection:
- The Set collection does not change when adding an item that already belonged to the set. So you don't have to worry about duplicates in query 1, where the returned type is Set.
- The List collection allows for duplicate items. But **queries 2 and 3 (which return Lists) must not return collections containing duplicate items**. Make sure each actor/movie appears in the list no more than once.
- In query 4, if the same film fits into more than one category, it must be present in all corresponding sets. As a result, the movie will appear more than once within the Map.

You can implement the `Queries` class methods in two ways:

- Through direct manipulation of collections, building Lists, Sets and Maps manually, iterating collections using `for` and calling methods like `add()`, `addAll()` and `get()`.
- Through the `java.util.stream` API, calling methods like `stream`, `filter`, `map`, `flatMap` and `collect`.

Both forms are valid, and it is even possible to use both at the same time. The important thing is that the data is returned according to the requirement of each query.

## Code validating

To be able to run your code and verify that it works, you can use a `Main` class, according to the following model:

- `Main.java`
```java
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    Queries queries = new Queries(Movies.all());
    Set<String> results = queries.actorsWhoPlayedThemselves();
    System.out.println(results);
  }
}
```

The `Movies` class contains some movies that have incomplete data, but that serve the purpose of validating the result of the queries. This class will be available for you to use and also read the source code, if you need it. There is another auxiliary class, `MovieBuilder`, which will also be made available, but you don't need to worry about it, as its function is to facilitate the loading of data from the `Movies` class.

To ensure the full experience, don't take your eyes off the screen. Good movie! I mean... good luck with the challenge! 🍿

---