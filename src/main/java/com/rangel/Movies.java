package com.rangel;

import java.util.Set;

public class Movies {

    public static final Movie spaceJam2021 = new MovieBuilder("Space Jam", 2021)
            .categories("Family", "Animation", "Comedy", "SiFi")
            .directors("Malcolm D. Lee")
            .character("LeBron James", "LeBron James", "Stephen Kankole")
            .character("AI G", "Don Cheadle")
            .character("Dominic 'Dom' James", "Cedric Joe")
            .build();

    public static final Movie beingJohnMalkovich = new MovieBuilder("Being John Malkovich", 1999)
            .categories("Comedy", "Drama", "Fantasy")
            .directors("Spike Jonze")
            .character("Craig Schwartz", "John Cusack")
            .character("John Malkovich", "John Malkovich")
            .character("Lotte Schwartz", "Cameron Diaz")
            .character("Maxine Lund", "Catherine Keener")
            .character("Floris", "Mary Kay Place")
            .build();

    public static final Movie spiderManNoWayHome = new MovieBuilder("Spider-Man: No Way Home", 2021)
            .categories("Action", "Adventure", "SiFi")
            .directors("Jon Watts")
            .character("Peter Parker / Homem Aranha", "Tom Holland")
            .character("Michelle 'MJ' Jones", "Zendaya")
            .character("Stephen Strange / Doutor Estranho", "Benedict Cumberbatch")
            .character("Max Dillon / Electro", "Jamie Foxx")
            .character("Dr. Otto Octavius / Doutor Octopus", "Alfred Molina")
            .build();

    /**
     * @return
     */
    public static Set<Movie> all() {
        return Set.of(
            spaceJam2021,
        );
    }
}
