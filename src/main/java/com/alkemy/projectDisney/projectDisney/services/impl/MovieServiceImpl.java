package com.alkemy.projectDisney.projectDisney.services.impl;

import com.alkemy.projectDisney.projectDisney.dto.MovieDTO;
import com.alkemy.projectDisney.projectDisney.entities.MovieEntity;
import com.alkemy.projectDisney.projectDisney.mappers.MovieMapper;
import com.alkemy.projectDisney.projectDisney.repositories.MovieRepository;
import com.alkemy.projectDisney.projectDisney.services.CharacterService;
import com.alkemy.projectDisney.projectDisney.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    public MovieMapper movieMapper;
    @Autowired
    public MovieRepository movieRepository;


    public MovieDTO save(MovieDTO dto){
        MovieEntity mEntity = movieMapper.movieDTO2Entity(dto);
        MovieEntity mEntitySaved = movieRepository.save(mEntity);
        MovieDTO result = movieMapper.movieEntity2DTO(mEntitySaved);

        return result;
    }

    public List<MovieDTO> getAllMovies() {
        List<MovieEntity> entities = movieRepository.findAll();
        List<MovieDTO> result = movieMapper.movieEntityList2MovieDTOList(entities);

        return result;
    }

}
