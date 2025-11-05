package com.smartrabbit.movie_play.domain;

public enum Genre {
    // 1. Las constantes deben terminar con un punto y coma
    // 2. Las constantes con argumento llaman al constructor
    ACTION("Action"),
    COMEDY("Comedy"),
    DRAMA("Drama"),
    HORROR("Horror"),
    ANIMATED("Animated"), // Corregí el typo
    SCI_FI("Sci-Fi"); // Usé guion medio en el valor, no en el nombre

    // 3. Campo privado para almacenar el valor legible
    private final String displayName;

    // 4. Constructor
    Genre(String displayName) {
        this.displayName = displayName;
    }

    // 5. Getter para obtener el valor
    public String getDisplayName() {
        return displayName;
    }
}
