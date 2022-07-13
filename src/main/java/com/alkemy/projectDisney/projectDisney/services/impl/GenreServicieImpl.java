package com.alkemy.projectDisney.projectDisney.services.impl;

import com.alkemy.projectDisney.projectDisney.dto.GenreDTO;
import com.alkemy.projectDisney.projectDisney.entities.GenreEntity;
import com.alkemy.projectDisney.projectDisney.mappers.GenreMapper;
import com.alkemy.projectDisney.projectDisney.repositories.GenreRepository;
import com.alkemy.projectDisney.projectDisney.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServicieImpl implements GenreService {

    @Autowired
    GenreMapper genreMapper;

    @Autowired
    GenreRepository genreRepository;


    public GenreDTO save(GenreDTO dto) {

        GenreEntity gEntity = genreMapper.genreDTO2Entity(dto);
        GenreEntity gEntitySaved = genreRepository.save(gEntity);
        GenreDTO result = genreMapper.genreEntity2DTO(gEntitySaved);

        return result;
    }
}
