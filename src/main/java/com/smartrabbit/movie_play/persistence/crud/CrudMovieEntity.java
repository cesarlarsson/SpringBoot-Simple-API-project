package com.smartrabbit.movie_play.persistence.crud;

import com.smartrabbit.movie_play.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMovieEntity extends CrudRepository<MovieEntity,Long> {
    MovieEntity findByTitle(String title);
}
