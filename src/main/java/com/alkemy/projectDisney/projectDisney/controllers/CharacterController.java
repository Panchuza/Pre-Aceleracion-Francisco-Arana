package com.alkemy.projectDisney.projectDisney.controllers;

import com.alkemy.projectDisney.projectDisney.dto.CharacterDTO;
import com.alkemy.projectDisney.projectDisney.services.CharacterService;
import com.alkemy.projectDisney.projectDisney.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("characters")
public class CharacterController {

    @Autowired
    CharacterService characterService;
    @Autowired
    private MovieService movieService;

//    @Autowired
//    public CharacterController(CharacterService characterService) {
//        this.characterService = characterService;
//    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CharacterDTO>> getAll(){
        List<CharacterDTO> characters = characterService.getAllCharacters();
        return ResponseEntity.ok().body(characters);
    }

    @PostMapping
    public ResponseEntity<CharacterDTO> save(@RequestBody CharacterDTO character) {

        CharacterDTO characterSaved = characterService.save(character);

        return ResponseEntity.status(HttpStatus.CREATED).body(characterSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CharacterDTO> delete(@PathVariable Long id) {
        this.characterService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterDTO> modify(@PathVariable Long id, @RequestBody CharacterDTO characterDTO) {

        CharacterDTO editedCharacter = characterService.modify(id, characterDTO);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(editedCharacter);
    }

//    @PutMapping("/{id}/movie/{idMovie}")
//    public ResponseEntity<Void> addMovie(@PathVariable Long id, @PathVariable Long idMovie) {
//        this.characterService.addMovie(id, idMovie);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }

    @DeleteMapping("/{id}/movie/{idMovie}")
    public ResponseEntity<Void> removeMovie(@PathVariable Long id, @PathVariable Long idMovie) {
        this.characterService.removeMovie(id, idMovie);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{movieId}/character/{charId}")
    public ResponseEntity<Void> addCharacter(@PathVariable Long movieId, @RequestParam Long characterId) {
        movieService.addCharacter(movieId, characterId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //PRUEBA CRITERIA
    @GetMapping("/characters")
    public ResponseEntity<List<CharacterDTO>> getByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Set<Long> movies,
            @RequestParam(required = false) Integer age){
        List<CharacterDTO> dtoList = this.characterService.getByFilters(name, movies, age);
        return ResponseEntity.ok(dtoList);
    }
}
