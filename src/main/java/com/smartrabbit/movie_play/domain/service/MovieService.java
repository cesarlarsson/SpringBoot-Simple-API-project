package com.smartrabbit.movie_play.domain.service;

import com.smartrabbit.movie_play.domain.dto.MovieDto;
import com.smartrabbit.movie_play.domain.dto.UpdateMovieDto;
import com.smartrabbit.movie_play.domain.repository.MovieRepository;
import com.smartrabbit.movie_play.persistence.entity.MovieEntity;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Tool("Busca todas las peliculas que existan dentro de la plataforma")
    public List<MovieDto> getAll(){
        return this.movieRepository.getAll();
    }

    public MovieDto getMovieById(Long id){
        return this.movieRepository.getMovieById(id);
    }

    public MovieDto save(MovieDto movieDto){
        return this.movieRepository.save(movieDto);
    }

    public MovieDto update(long id, UpdateMovieDto updateMovieDto){
        return this.movieRepository.update(id,updateMovieDto);
    }

    public void delete(long id){
        this.movieRepository.delete(id);
    }
}
