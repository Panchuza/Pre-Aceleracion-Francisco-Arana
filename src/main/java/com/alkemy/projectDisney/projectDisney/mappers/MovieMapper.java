package com.alkemy.projectDisney.projectDisney.mappers;

import com.alkemy.projectDisney.projectDisney.dto.MovieDTO;
import com.alkemy.projectDisney.projectDisney.entities.MovieEntity;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {

    public MovieEntity movieDTO2Entity(MovieDTO dto) {

        MovieEntity movieEntity = new MovieEntity();

        movieEntity.setImage(dto.getImage());
        movieEntity.setScore(dto.getScore());
        movieEntity.setTitle(dto.getTitle());

        return movieEntity;
    }

    public MovieDTO movieEntity2DTO(MovieEntity entity) {
        MovieDTO dto = new MovieDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setScore(entity.getScore());
        dto.setTitle(entity.getTitle());

        return dto;
    }

    public List<MovieDTO> movieEntityList2MovieDTOList(List<MovieEntity> entities) {

        List<MovieDTO> dtos = new ArrayList<>();

        for (MovieEntity mEntity: entities) {
             dtos.add(movieEntity2DTO(mEntity));
        }

        return dtos;
    }

    public List<MovieEntity> movieDTOList2EntityList(List<MovieDTO> dtoList) {
        List<MovieEntity> entities = new ArrayList<>();

        for (MovieDTO dto : dtoList) {
            entities.add(this.movieDTO2Entity(dto));
        }
        return entities;
    }
}
