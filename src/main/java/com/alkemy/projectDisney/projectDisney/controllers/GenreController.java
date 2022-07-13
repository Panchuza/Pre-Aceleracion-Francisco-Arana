package com.alkemy.projectDisney.projectDisney.controllers;

import com.alkemy.projectDisney.projectDisney.dto.GenreDTO;
import com.alkemy.projectDisney.projectDisney.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("genres")
public class GenreController {

    @Autowired
    public GenreService genreService;

    @PostMapping
    public ResponseEntity<GenreDTO> save(@RequestBody GenreDTO genre){

        GenreDTO genreSaved = genreService.save(genre);//save genre

        return ResponseEntity.status(HttpStatus.CREATED).body(genreSaved);//201 genre saved
    }

}
