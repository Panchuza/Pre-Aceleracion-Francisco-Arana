package com.alkemy.projectDisney.projectDisney.services;

import com.alkemy.projectDisney.projectDisney.dto.GenreDTO;
import com.alkemy.projectDisney.projectDisney.entities.GenreEntity;

public interface GenreService {

    GenreDTO save (GenreDTO dto);
    GenreEntity getGenreById(Long genreId);
}
