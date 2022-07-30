package com.alkemy.projectDisney.projectDisney.mappers;

import com.alkemy.projectDisney.projectDisney.dto.GenreBasicDTO;
import com.alkemy.projectDisney.projectDisney.dto.GenreDTO;
import com.alkemy.projectDisney.projectDisney.entities.GenreEntity;
import org.springframework.stereotype.Component;


@Component
public class GenreMapper {

    public GenreEntity genreDTO2Entity(GenreDTO dto) {

        GenreEntity genreEntity = new GenreEntity();

        genreEntity.setName(dto.getName());
        genreEntity.setImage(dto.getImage());

        return genreEntity;
    }

    public GenreDTO genreEntity2DTO(GenreEntity entity, boolean loadMovie) {
        GenreDTO dto = new GenreDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());

        return dto;
    }

    public GenreBasicDTO genreEntity2BasicDTO(GenreEntity entity, boolean loadMovie) {
        GenreBasicDTO dto = new GenreBasicDTO();

        dto.setName(entity.getName());

        return dto;
    }

}
