package com.alkemy.projectDisney.projectDisney.services.impl;

import com.alkemy.projectDisney.projectDisney.dto.CharacterDTO;
import com.alkemy.projectDisney.projectDisney.entities.CharacterEntity;
import com.alkemy.projectDisney.projectDisney.mappers.CharacterMapper;
import com.alkemy.projectDisney.projectDisney.repositories.CharacterRepository;
import com.alkemy.projectDisney.projectDisney.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;


public class CharacterServiceImpl implements CharacterService {

    @Autowired
    CharacterMapper characterMapper;

    @Autowired
    CharacterRepository characterRepository;


    public CharacterDTO save(CharacterDTO dto) {

        CharacterEntity cEntity = characterMapper.characterDTO2Entity(dto);
        CharacterEntity cEntitySaved = characterRepository.save(cEntity);
        CharacterDTO result = characterMapper.characterEntity2DTO(cEntitySaved);

        return result;
    }

}
