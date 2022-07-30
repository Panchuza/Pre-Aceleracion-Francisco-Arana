package com.alkemy.projectDisney.projectDisney.services;

import com.alkemy.projectDisney.projectDisney.dto.CharacterDTO;
import com.alkemy.projectDisney.projectDisney.entities.CharacterEntity;


import java.util.List;
import java.util.Set;

public interface CharacterService {

    CharacterDTO save (CharacterDTO dto);

    CharacterEntity getCharacterById(Long id);

    void addMovie(Long id, Long idMovie);

    void removeMovie(Long id, Long idMovie);

    void delete(Long id);

    CharacterDTO modify(Long id, CharacterDTO characterDTO);

    List<CharacterDTO> getAllCharacters();

    List<CharacterDTO> getByFilters(String name, Set<Long> movies, Integer age);
}
