package com.alkemy.projectDisney.projectDisney.mappers;

import com.alkemy.projectDisney.projectDisney.dto.MovieBasicDTO;
import com.alkemy.projectDisney.projectDisney.dto.MovieDTO;
import com.alkemy.projectDisney.projectDisney.entities.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {

    //PRUEBA
    @Lazy
    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private GenreMapper genreMapper;
    //FIN PRUEBA
    public MovieEntity movieDTO2Entity(MovieDTO dto, boolean load) {

        MovieEntity movieEntity = new MovieEntity();

        movieEntity.setImage(dto.getImage());
        movieEntity.setScore(dto.getScore());
        movieEntity.setTitle(dto.getTitle());
        //PRUEBA
        String date = dto.getCreationDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate transformedDate = LocalDate.parse(date, formatter);
        movieEntity.setCreationDate(transformedDate);
        //FIN PRUEBA
        return movieEntity;
    }

    public MovieDTO movieEntity2DTO(MovieEntity entity, boolean load) {
        MovieDTO dto = new MovieDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setScore(entity.getScore());
        dto.setTitle(entity.getTitle());

        //PRUEBA
        //1. Get la forma original de la fecha
        LocalDate date = entity.getCreationDate();
        //2. Convierte en String
        String formatDate = date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        dto.setCreationDate(formatDate);
        if (load) {
            dto.setCharacters(characterMapper.characterEntityList2BasicDTOList(entity.getCharacters(), true));
            dto.setGenre(genreMapper.genreEntity2BasicDTO(entity.getGenre(), true));
        }
        //FIN PRUEBA
        return dto;
    }

    public List<MovieDTO> movieEntityList2MovieDTOList(List<MovieEntity> entities, boolean load) {

        List<MovieDTO> dtos = new ArrayList<>();

        for (MovieEntity mEntity: entities) {
             dtos.add(movieEntity2DTO(mEntity, load));
        }

        return dtos;
    }

    public List<MovieEntity> movieDTOList2EntityList(List<MovieDTO> dtoList, boolean load) {
        List<MovieEntity> entities = new ArrayList<>();

        for (MovieDTO dto : dtoList) {
            entities.add(this.movieDTO2Entity(dto, load));
        }
        return entities;
    }

    //PRUEBA CRITERIA

    public List<MovieBasicDTO> movieEntityList2MovieBasicDTOList(List<MovieEntity> entities, boolean load) {

        List<MovieBasicDTO> dtos = new ArrayList<>();

        for (MovieEntity mEntity: entities) {
            dtos.add(movieEntity2BasicDTO(mEntity, load));
        }

        return dtos;
    }
//
    public MovieBasicDTO movieEntity2BasicDTO(MovieEntity entity, boolean load) {
        MovieBasicDTO dto = new MovieBasicDTO();
        dto.setImage(entity.getImage());
        dto.setTitle(entity.getTitle());
        //1. Get la forma original de la fecha
        LocalDate date = entity.getCreationDate();
        //2. Convierte en String
        String formatDate = date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        dto.setCreationDate(formatDate);
        return dto;
    }
}
