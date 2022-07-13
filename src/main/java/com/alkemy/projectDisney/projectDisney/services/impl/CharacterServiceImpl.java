package com.alkemy.projectDisney.projectDisney.services.impl;

import com.alkemy.projectDisney.projectDisney.dto.CharacterDTO;
import com.alkemy.projectDisney.projectDisney.entities.CharacterEntity;
import com.alkemy.projectDisney.projectDisney.entities.MovieEntity;
import com.alkemy.projectDisney.projectDisney.exceptions.ParamNotFound;
import com.alkemy.projectDisney.projectDisney.mappers.CharacterMapper;
import com.alkemy.projectDisney.projectDisney.repositories.CharacterRepository;
import com.alkemy.projectDisney.projectDisney.services.CharacterService;
import com.alkemy.projectDisney.projectDisney.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.Optional;

public class CharacterServiceImpl implements CharacterService {

    @Autowired
    CharacterMapper characterMapper;

    @Autowired
    CharacterRepository characterRepository;

//PRUEBA
//    @Lazy
//    @Autowired
//    private MovieService movieService;

    public CharacterDTO save(CharacterDTO dto) {

        CharacterEntity cEntity = characterMapper.characterDTO2Entity(dto);
        CharacterEntity cEntitySaved = characterRepository.save(cEntity);
        CharacterDTO result = characterMapper.characterEntity2DTO(cEntitySaved);

        return result;
    }
//PRUEBA
//    @Override
//    public CharacterEntity getCharacterById(Long id) {
//        Optional<CharacterEntity> characterEntity = characterRepository.findById(id);
//        if (!characterEntity.isPresent()) {
//            throw new ParamNotFound("This Disney character does not exist."+ id);
//        }
//        return characterEntity.get();
//    }
//
//    @Override
//    public void addMovie(Long id, Long idMovie) {
//        CharacterEntity charEntity = characterRepository.getById(id);
//        charEntity.getMovies().size();
//        MovieEntity movie = this.movieService.getById(idMovie);
//        charEntity.getMovies().add(movie);
//        this.characterRepository.save(charEntity);
//    }
//
//    @Override
//    public void removeMovie(Long id, Long idMovie) {
//        CharacterEntity charEntity = characterRepository.getById(id);
//        charEntity.getMovies().size();
//        MovieEntity movie = this.movieService.getById(idMovie);
//        charEntity.getMovies().remove(movie);
//        this.characterRepository.save(charEntity);
//    }
}
