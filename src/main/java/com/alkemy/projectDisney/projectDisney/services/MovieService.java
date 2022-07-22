package com.alkemy.projectDisney.projectDisney.services;

import com.alkemy.projectDisney.projectDisney.dto.MovieDTO;
import com.alkemy.projectDisney.projectDisney.entities.MovieEntity;

import java.util.List;

public interface MovieService {

    MovieDTO save (MovieDTO dto);

    List<MovieDTO> getAllMovies();
//PRUEBA
    void addCharacter(Long movieId, Long characterId);

    MovieEntity getById(Long id);

    void deleteMovieById(Long id);

    MovieDTO modify (Long id, MovieDTO movieDTO);

    List<MovieDTO> getAllMoviesAndCharacters();

    void addGenre(Long movieId, Long genreId);
}
