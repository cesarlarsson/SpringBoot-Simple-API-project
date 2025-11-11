package com.smartrabbit.movie_play.domain.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Long movieId){
        super("La película con ID "+movieId+" no existe en la plataforma");
    }
}
