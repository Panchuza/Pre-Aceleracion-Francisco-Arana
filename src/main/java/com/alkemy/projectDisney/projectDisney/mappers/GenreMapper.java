package com.alkemy.projectDisney.projectDisney.mappers;

import com.alkemy.projectDisney.projectDisney.dto.GenreDTO;
import com.alkemy.projectDisney.projectDisney.entities.GenreEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenreMapper {

    public GenreEntity genreDTO2Entity(GenreDTO dto) {

        GenreEntity genreEntity = new GenreEntity();

        genreEntity.setName(dto.getName());
        genreEntity.setImage(dto.getImage());

        return genreEntity;
    }

    public GenreDTO genreEntity2DTO(GenreEntity entity) {
        GenreDTO dto = new GenreDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());

        return dto;
    }

    public List<GenreDTO> genreEntityList2GenreDTOList(List<GenreEntity> entities) {

        List<GenreDTO> dtos = new ArrayList<>();

        for (GenreEntity gEntity: entities) {

            dtos.add(genreEntity2DTO(gEntity));
        }
        return dtos;
    }
}