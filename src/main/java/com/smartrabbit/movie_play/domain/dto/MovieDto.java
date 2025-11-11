package com.smartrabbit.movie_play.domain.dto;

import com.smartrabbit.movie_play.domain.Genre;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record MovieDto(
        Long id,
        @NotBlank(message = "El titulo es requerido")
        String title,
        Integer duration,
        Genre genre,
        LocalDate releaseDate,
        Double rating
) {

}
