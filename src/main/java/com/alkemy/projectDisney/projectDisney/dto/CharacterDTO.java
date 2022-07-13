package com.alkemy.projectDisney.projectDisney.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDTO {

    public Long id;
    public String image;
    public String name;
    public Integer age;
    public Integer weight;
    public String history;
}
