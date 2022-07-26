package com.alkemy.projectDisney.projectDisney.repositories.specification;

import com.alkemy.projectDisney.projectDisney.dto.CharacterFilterDTO;
import com.alkemy.projectDisney.projectDisney.entities.CharacterEntity;
import com.alkemy.projectDisney.projectDisney.entities.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterSpecification {

    public Specification<CharacterEntity> getFiltered(CharacterFilterDTO characterFilters){

        // Lambda Function:
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // == Name ==
            if(StringUtils.hasLength(characterFilters.getName())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("name")),
                                "%" + characterFilters.getName().toLowerCase() + "%"
                        )
                );
            }
            // == Movies ==
            if(!CollectionUtils.isEmpty(characterFilters.getMovies())) {
                Join<CharacterEntity, MovieEntity> join = root.join("charactersMovie", JoinType.INNER);
                Expression<String> movieId = join.get("id");
                predicates.add(movieId.in(characterFilters.getMovies()));
            }
            //Remove duplicates
            query.distinct(true);

            // MAIN RETURN:
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
