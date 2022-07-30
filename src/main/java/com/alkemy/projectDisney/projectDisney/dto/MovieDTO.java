package com.alkemy.projectDisney.projectDisney.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class MovieDTO {

    private Long id;
    private String image;
    private Integer score;
    private String title;
    private String creationDate;
    private List<CharacterBasicDTO> characters;
    private GenreBasicDTO genre;
}
