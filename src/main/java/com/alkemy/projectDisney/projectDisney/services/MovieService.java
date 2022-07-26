package com.alkemy.projectDisney.projectDisney.services;

import com.alkemy.projectDisney.projectDisney.dto.MovieBasicDTO;
import com.alkemy.projectDisney.projectDisney.dto.MovieDTO;
import com.alkemy.projectDisney.projectDisney.entities.MovieEntity;

import java.util.List;
import java.util.Set;

public interface MovieService {

    MovieDTO save (MovieDTO dto);

    List<MovieDTO> getAllMovies();
    void addCharacter(Long movieId, Long characterId);

    MovieEntity getById(Long id);

    void deleteMovieById(Long id);

    MovieDTO modify (Long id, MovieDTO movieDTO);

    List<MovieDTO> getAllMoviesAndCharacters();

    void addGenre(Long movieId, Long genreId);

    //PRUEBA CRITERIA
    List<MovieBasicDTO> getByFilters(String name, Set<Long> characters, String order);
}
