package com.smartrabbit.movie_play.web.controller;

import com.smartrabbit.movie_play.domain.dto.MovieDto;
import com.smartrabbit.movie_play.domain.dto.SuggestionDto;
import com.smartrabbit.movie_play.domain.dto.UpdateMovieDto;
import com.smartrabbit.movie_play.domain.service.MoviePlayAIService;
import com.smartrabbit.movie_play.domain.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parent")
public class MovieController {
    private final MovieService movieService;
    private final MoviePlayAIService moviePlayAIService;

    public MovieController(MovieService movieService, MoviePlayAIService moviePlayAIService) {
        this.movieService = movieService;
        this.moviePlayAIService = moviePlayAIService;
    }

   /* @GetMapping("/movies")
    public List<MovieDto> getAll(){
       return this.movieService.getAll();
    }*/

   /* @GetMapping("/movies/{id}")
    public MovieDto getMovieByID(@PathVariable long id){
        return this.movieService.getMovieById(id);
    }*/

    @GetMapping("/movies")
    public ResponseEntity<List<MovieDto>> getAll(){
        List<MovieDto> movieDto = this.movieService.getAll();
        if(movieDto == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(movieDto);
        }
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<MovieDto> getMovieByID(@PathVariable long id){
         MovieDto movieDto = this.movieService.getMovieById(id);

         if(movieDto == null){
             return ResponseEntity.notFound().build();
         }else{
             return ResponseEntity.ok(movieDto);
         }
    }

    @PostMapping("/suggestion")
    public ResponseEntity<String> generateMovieSuggestion(@RequestBody SuggestionDto userMessage){
         return ResponseEntity.ok().body(this.moviePlayAIService.generateMovieSuggestion(userMessage.userPreferences()));
    }

    @PostMapping("/movies")
    public  ResponseEntity<MovieDto> saveMovie(@RequestBody @Valid MovieDto movieDto){
        MovieDto movieDTOResponse=this.movieService.save(movieDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieDTOResponse);

    }
    @PutMapping("/movies/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable Long id, @RequestBody @Valid UpdateMovieDto movieDto){
        MovieDto movieDTOResponse=this.movieService.update(id,movieDto);

        return ResponseEntity.status(HttpStatus.OK).body(movieDTOResponse);

    }
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Valid Long id){
        this.movieService.delete(id);
        //return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok().build();
    }
}
