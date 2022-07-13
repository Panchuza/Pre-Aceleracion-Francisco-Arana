package com.alkemy.projectDisney.projectDisney.mappers;

import com.alkemy.projectDisney.projectDisney.dto.CharacterDTO;
import com.alkemy.projectDisney.projectDisney.entities.CharacterEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public CharacterDTO characterEntity2DTO(CharacterEntity entity, boolean loadMovie) {

        CharacterDTO dto = new CharacterDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());
        dto.setAge(entity.getAge());
        dto.setHistory(entity.getHistory());
        dto.setWeight(entity.getWeight());

        return dto;
    }

    //PRUEBA
//    public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> entities, boolean loadMovie) {
//        List<CharacterDTO> dtoList = new ArrayList<>();
//
//        for (CharacterEntity entity : entities) {
//            dtoList.add(characterEntity2DTO(entity, loadMovie));
//        }
//        return dtoList;
//    }
//
//    public List<CharacterEntity> characterDTOList2EntityList(List<CharacterDTO> dtoList, boolean load) {
//        List<CharacterEntity> entities = new ArrayList<>();
//
//        for (CharacterDTO dto : dtoList) {
//            entities.add(this.characterDTO2Entity(dto));
//        }
//        return entities;
//    }

}
