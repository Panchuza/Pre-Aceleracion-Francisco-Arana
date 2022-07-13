package com.alkemy.projectDisney.projectDisney.mappers;

import com.alkemy.projectDisney.projectDisney.dto.CharacterDTO;
import com.alkemy.projectDisney.projectDisney.entities.CharacterEntity;
import org.springframework.stereotype.Component;


@Component
public class CharacterMapper {

    public CharacterEntity characterDTO2Entity(CharacterDTO dto) {

        CharacterEntity characterEntity = new CharacterEntity();

        characterEntity.setName(dto.getName());
        characterEntity.setAge(dto.getAge());
        characterEntity.setImage(dto.getImage());
        characterEntity.setHistory(dto.getHistory());
        characterEntity.setWeight(dto.getWeight());

        return characterEntity;
    }

    public CharacterDTO characterEntity2DTO(CharacterEntity entity) {

        CharacterDTO dto = new CharacterDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());
        dto.setAge(entity.getAge());
        dto.setHistory(entity.getHistory());
        dto.setWeight(entity.getWeight());

        return dto;
    }

}
