package com.alkemy.projectDisney.projectDisney.services.impl;

import com.alkemy.projectDisney.projectDisney.dto.MovieDTO;
import com.alkemy.projectDisney.projectDisney.entities.CharacterEntity;
import com.alkemy.projectDisney.projectDisney.entities.MovieEntity;
import com.alkemy.projectDisney.projectDisney.exceptions.ParamNotFound;
import com.alkemy.projectDisney.projectDisney.mappers.MovieMapper;
import com.alkemy.projectDisney.projectDisney.repositories.MovieRepository;
import com.alkemy.projectDisney.projectDisney.services.CharacterService;
import com.alkemy.projectDisney.projectDisney.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    public MovieMapper movieMapper;
    @Autowired
    public MovieRepository movieRepository;
    @Autowired
    public CharacterService characterService;

    public MovieDTO save(MovieDTO dto){
        MovieEntity mEntity = movieMapper.movieDTO2Entity(dto);
        MovieEntity mEntitySaved = movieRepository.save(mEntity);
        MovieDTO result = movieMapper.movieEntity2DTO(mEntitySaved);

        return result;
    }

    public List<MovieDTO> getAllMovies() {
        List<MovieEntity> entities = movieRepository.findAll();
        List<MovieDTO> result = movieMapper.movieEntityList2MovieDTOList(entities);

        return result;
    }
//PRUEBA
//    public void addCharacter(Long movieId, Long characterId) {
//        MovieEntity movieEntity = this.getById(movieId);
//        movieEntity.getCharacters().size();
//
//        CharacterEntity character = characterService.getCharacterById(characterId);
//        movieEntity.getCharacters().add(character);
//        movieRepository.save(movieEntity);
//    }
//
//    @Override
//    public MovieEntity getById(Long id) {
//        Optional<MovieEntity> movieEntity = movieRepository.findById(id);
//        if (!movieEntity.isPresent()) {
//            throw new ParamNotFound("Movie does not exist.");
//        }
//        return movieEntity.get();
//    }
}
