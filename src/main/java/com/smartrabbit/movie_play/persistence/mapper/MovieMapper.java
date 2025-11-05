package com.smartrabbit.movie_play.persistence.mapper;

import com.smartrabbit.movie_play.domain.dto.MovieDto;
import com.smartrabbit.movie_play.domain.dto.UpdateMovieDto;
import com.smartrabbit.movie_play.persistence.entity.MovieEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenreMapper.class})
public interface MovieMapper {
    @Mapping(source = "title", target = "title")
    @Mapping(source = "duration",target = "duration")
    @Mapping(source = "startDate",target = "releaseDate")
    @Mapping(source = "classification",target = "rating")
    @Mapping(source = "genre",target = "genre",qualifiedByName = "stringToGenre")
    MovieDto toDto(MovieEntity entity);
    List<MovieDto> toDto(Iterable<MovieEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "genre", target = "genre", qualifiedByName = "genreToString")
    MovieEntity toEntity(MovieDto dto);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "releaseDate",target = "startDate")
    @Mapping(source = "rating",target = "classification")
    void UpdateEntityFromDto(UpdateMovieDto dto, @MappingTarget MovieEntity entity);
}
