package com.alkemy.projectDisney.projectDisney.repositories;

import com.alkemy.projectDisney.projectDisney.entities.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    //PRUEBA CRITERIA
    List<MovieEntity> findAll(Specification<MovieEntity> entitySpecification);
}
