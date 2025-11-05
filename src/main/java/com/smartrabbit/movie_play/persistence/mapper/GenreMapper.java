package com.smartrabbit.movie_play.persistence.mapper;

import com.smartrabbit.movie_play.domain.Genre;
import org.mapstruct.Named;

public class GenreMapper {

    @Named("stringToGenre")
    public static Genre stringToGenre(String genre){
        if(genre == null) return null;

        return switch (genre.toUpperCase()){
            case "ACTION" -> Genre.ACTION;
            case "SCIENCE FICTION" -> Genre.SCI_FI;
            case "COMEDY" -> Genre.COMEDY;
            default -> null;
        };
    }

    @Named("genreToString")
    public static String genreToString(Genre genre){
        if(genre == null) return null;

        return switch (genre) {
            case ACTION -> "ACTION";
            case COMEDY -> "COMEDY";
            case SCI_FI -> "SCIENCE FICTION";
            default -> "";
        };
    }
}
