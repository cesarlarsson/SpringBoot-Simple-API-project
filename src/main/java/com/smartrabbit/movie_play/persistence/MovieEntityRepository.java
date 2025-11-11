package com.smartrabbit.movie_play.persistence;

import com.smartrabbit.movie_play.domain.dto.MovieDto;
import com.smartrabbit.movie_play.domain.dto.UpdateMovieDto;
import com.smartrabbit.movie_play.domain.exception.MovieAlreadyExistException;
import com.smartrabbit.movie_play.domain.exception.MovieNotFoundException;
import com.smartrabbit.movie_play.domain.repository.MovieRepository;
import com.smartrabbit.movie_play.persistence.crud.CrudMovieEntity;
import com.smartrabbit.movie_play.persistence.entity.MovieEntity;
import com.smartrabbit.movie_play.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {
    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }


    @Override
    public List<MovieDto> getAll() {

        return this.movieMapper.toDto(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieDto getMovieById(Long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        return this.movieMapper.toDto(movieEntity);

    }

    @Override
    public MovieDto save(MovieDto movieDto) {

        if (this.crudMovieEntity.findByTitle(movieDto.title()) != null) {

            throw new MovieAlreadyExistException(movieDto.title());
        }

        MovieEntity movieEntity =this.movieMapper.toEntity(movieDto);
        movieEntity.setState("D");
        MovieEntity movieEntityCreated = this.crudMovieEntity.save(movieEntity);

        return this.movieMapper.toDto(movieEntityCreated);
    }

    @Override
    public MovieDto update(Long id, UpdateMovieDto updateMovieDto) {
        //validate that the id exist
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        if (movieEntity == null) {
            return null;
        }else{
            //Fist option
            // movieEntity.setTitle(updateMovieDto.title());
            // movieEntity.setStartDate(updateMovieDto.releaseDate());
            // movieEntity.setClassification(BigDecimal.valueOf(updateMovieDto.rating()));
            //Other option using the mapper
            this.movieMapper.UpdateEntityFromDto(updateMovieDto,movieEntity);

            return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
        }


    }

    @Override
    public void delete(Long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
        this.crudMovieEntity.deleteById(id);
    }


}
