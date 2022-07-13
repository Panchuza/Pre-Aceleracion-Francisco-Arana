package com.alkemy.projectDisney.projectDisney.services;

import com.alkemy.projectDisney.projectDisney.dto.MovieDTO;


import java.util.List;

public interface MovieService {

    MovieDTO save (MovieDTO dto);

    List<MovieDTO> getAllMovies();

}
