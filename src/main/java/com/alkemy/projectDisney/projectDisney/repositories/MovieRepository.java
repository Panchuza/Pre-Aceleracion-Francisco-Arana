package com.alkemy.projectDisney.projectDisney.repositories;

import com.alkemy.projectDisney.projectDisney.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
}
