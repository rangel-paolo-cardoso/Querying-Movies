package com.rangel;

import static java.util.Collections.emptySet;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;

import java.util.Collection;
import java.util.List;
import java.util.Map;
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
    * <p>It is considered that "actors who played themselves" those who have their names as a key 
    * on the Map `actorsPerCharacter` and also as one of the items belonging to the set 
    * associated with this same key.</p>
    */
    public Set<String> actorsWhoPlayedThemselves() {
        return emptySet(); // TODO: Implement.
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
        return emptyList(); // TODO: Implement.
    }

    /**
    * Consulta 3: a partir da coleção de filmes desta classe, este método retorna a lista de filmes
    * em que pelo menos um dos diretores tenha atuado. A lista retornada está disposta em ordem de
    * lançamento, com os filmes mais recentes no início.
    *
    * <p>Considera-se "filmes em que pelo menos um dos diretores tenha atuado" aqueles em que
    * pelo menos um dos itens do campo `diretores` também é um item do campo `atores`.</p>
    */
    public List<Movie> moviesInWhichAtLeastOneDirectorActedMostRecentFirst() {
        return emptyList(); // TODO: Implement.
    }

    /**
    * Consulta 4: a partir da coleção de filmes desta classe, este método retorna um Map contendo
    * todos os filmes lançados em um determinado ano agrupados por categoria.
    *
    * <p>Cada chave do Map representa uma categoria, enquanto cada valor representa o
    * conjunto de filmes que se encaixam na categoria da chave correspondente.</p>
    */
    public Map<String, Set<Movie>> moviesReleasedInTheYearGroupedByCategory(int year) {
        return emptyMap(); // TODO: Implement (bônus).
    }
}
