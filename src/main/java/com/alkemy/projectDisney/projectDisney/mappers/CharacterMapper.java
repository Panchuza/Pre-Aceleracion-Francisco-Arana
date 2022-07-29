package com.alkemy.projectDisney.projectDisney.mappers;

import com.alkemy.projectDisney.projectDisney.dto.CharacterBasicDTO;
import com.alkemy.projectDisney.projectDisney.dto.CharacterDTO;
import com.alkemy.projectDisney.projectDisney.dto.MovieBasicDTO;
import com.alkemy.projectDisney.projectDisney.entities.CharacterEntity;
import com.alkemy.projectDisney.projectDisney.entities.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterMapper {


    @Autowired
    private MovieMapper movieMapper;

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

        if (loadMovie) {
            List<MovieBasicDTO> dtoList = new ArrayList<>();
            for (MovieEntity mEntity : entity.getMovies()) {
                dtoList.add(movieMapper.movieEntity2BasicDTO(mEntity, true));
            }
            dto.setMovies(dtoList);
        }

        return dto;
    }

    public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> entities, boolean loadMovie) {
        List<CharacterDTO> dtoList = new ArrayList<>();

        for (CharacterEntity entity : entities) {
            dtoList.add(characterEntity2DTO(entity, loadMovie));
        }
        return dtoList;
    }

    public List<CharacterEntity> characterDTOList2EntityList(List<CharacterDTO> dtoList, boolean load) {
        List<CharacterEntity> entities = new ArrayList<>();

        for (CharacterDTO dto : dtoList) {
            entities.add(this.characterDTO2Entity(dto));
        }
        return entities;
    }

    //PRUEBA CRITERIA
    public List<CharacterBasicDTO> characterEntityList2BasicDTOList(List<CharacterEntity> entities, boolean loadMovie) {
        List<CharacterBasicDTO> dtoList = new ArrayList<>();

        for (CharacterEntity entity : entities) {
            dtoList.add(characterEntity2BasicDTO(entity, loadMovie));
        }
        return dtoList;
    }

    public CharacterBasicDTO characterEntity2BasicDTO(CharacterEntity entity, boolean loadMovie) {

        CharacterBasicDTO dto = new CharacterBasicDTO();
        dto.setName(entity.getName());
        dto.setHistory(entity.getHistory());
        dto.setImage(entity.getImage());

        return dto;
    }
}
