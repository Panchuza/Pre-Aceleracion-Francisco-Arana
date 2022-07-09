package com.alkemy.projectDisney.projectDisney.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "characters")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CharacterEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid" , strategy = "uuid2")
    private String id;

    private String image;

    @Column(nullable = false)
    private String name;

    //@Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String history;

    @ManyToMany(mappedBy = "characters", cascade = CascadeType.ALL)
    private List<MovieEntity> movies = new ArrayList<>();

}
