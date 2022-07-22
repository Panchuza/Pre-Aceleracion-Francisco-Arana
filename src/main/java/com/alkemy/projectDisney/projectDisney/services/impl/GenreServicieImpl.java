package com.alkemy.projectDisney.projectDisney.services.impl;

import com.alkemy.projectDisney.projectDisney.dto.GenreDTO;
import com.alkemy.projectDisney.projectDisney.entities.GenreEntity;
import com.alkemy.projectDisney.projectDisney.entities.MovieEntity;
import com.alkemy.projectDisney.projectDisney.exceptions.ParamNotFound;
import com.alkemy.projectDisney.projectDisney.mappers.GenreMapper;
import com.alkemy.projectDisney.projectDisney.repositories.GenreRepository;
import com.alkemy.projectDisney.projectDisney.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenreServicieImpl implements GenreService {

    @Autowired
    GenreMapper genreMapper;

    @Autowired
    GenreRepository genreRepository;


    public GenreDTO save(GenreDTO dto) {

        GenreEntity gEntity = genreMapper.genreDTO2Entity(dto);
        GenreEntity gEntitySaved = genreRepository.save(gEntity);
        GenreDTO result = genreMapper.genreEntity2DTO(gEntitySaved, false);

        return result;
    }

    @Override
    public GenreEntity getGenreById(Long genreId) {
        Optional<GenreEntity> genreEntity = genreRepository.findById(genreId);
        if (!genreEntity.isPresent()) {
            throw new ParamNotFound("Genre does not exist.");
        }
        return genreEntity.get();
    }


}
