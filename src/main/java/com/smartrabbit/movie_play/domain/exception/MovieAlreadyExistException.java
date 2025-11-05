package com.smartrabbit.movie_play.domain.exception;

public class MovieAlreadyExistException extends RuntimeException {
    public MovieAlreadyExistException(String movieTitle){
        super("la pelicula "+movieTitle+" ya existe en la plataforma");
    }
}
