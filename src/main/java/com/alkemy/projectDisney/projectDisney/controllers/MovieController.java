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

    @PostMapping
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movie){
        MovieDTO movieSaved = movieService.save(movie); //save movie

        return ResponseEntity.status(HttpStatus.CREATED).body(movieSaved); //201 movie saved
    }
}
