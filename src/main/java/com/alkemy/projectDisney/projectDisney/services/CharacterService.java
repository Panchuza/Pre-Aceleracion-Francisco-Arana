package com.alkemy.projectDisney.projectDisney.services;

import com.alkemy.projectDisney.projectDisney.dto.CharacterDTO;
import com.alkemy.projectDisney.projectDisney.entities.CharacterEntity;

import java.util.List;

public interface CharacterService {

    CharacterDTO save (CharacterDTO dto);
    //PRUEBA

    CharacterEntity getCharacterById(Long id);

    void addMovie(Long id, Long idMovie);

    void removeMovie(Long id, Long idMovie);

    void delete(Long id);

    CharacterDTO modify(Long id, CharacterDTO characterDTO);

    List<CharacterDTO> getAllCharacters();
}
