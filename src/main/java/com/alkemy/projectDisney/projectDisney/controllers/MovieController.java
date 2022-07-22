package com.alkemy.projectDisney.projectDisney.controllers;


import com.alkemy.projectDisney.projectDisney.dto.MovieDTO;
import com.alkemy.projectDisney.projectDisney.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    public MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAll(){
        List<MovieDTO> movies = movieService.getAllMovies();
        return ResponseEntity.ok().body(movies);
    }
    @GetMapping("/alldetails")
    public ResponseEntity<List<MovieDTO>> getAllMovAndChar(){
        List<MovieDTO> movies = movieService.getAllMoviesAndCharacters();
        return ResponseEntity.ok().body(movies);
    }

    @PostMapping
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movie){
        MovieDTO movieSaved = movieService.save(movie); //save movie

        return ResponseEntity.status(HttpStatus.CREATED).body(movieSaved); //201 movie saved
    }

    //PRUEBA
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movieService.deleteMovieById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{movieId}/character/{characterId}")
    public ResponseEntity<Void> addCharacter(@PathVariable Long movieId, @PathVariable Long characterId) {
        movieService.addCharacter(movieId, characterId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/{movieId}/genre/{genreId}")
    public ResponseEntity<Void> addGenre(@PathVariable Long movieId, @PathVariable Long genreId) {
        movieService.addGenre(movieId, genreId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> modify(@PathVariable Long id, @RequestBody MovieDTO movieDTO) {

        MovieDTO editedMovie = movieService.modify(id, movieDTO);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(editedMovie);
    }
}
