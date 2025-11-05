package com.smartrabbit.movie_play.domain.repository;

import com.smartrabbit.movie_play.domain.dto.MovieDto;
import com.smartrabbit.movie_play.domain.dto.UpdateMovieDto;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();
    MovieDto getMovieById(Long id);
    MovieDto save(MovieDto movieDto);
    MovieDto update(Long id, UpdateMovieDto updateMovieDto);
    void delete(Long id);
}
