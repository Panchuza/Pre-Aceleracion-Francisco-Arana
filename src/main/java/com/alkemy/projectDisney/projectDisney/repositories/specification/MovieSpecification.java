package com.alkemy.projectDisney.projectDisney.repositories.specification;


import com.alkemy.projectDisney.projectDisney.dto.MovieFilterDTO;
import com.alkemy.projectDisney.projectDisney.entities.CharacterEntity;
import com.alkemy.projectDisney.projectDisney.entities.MovieEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;


@Component
public class MovieSpecification {
    public Specification<MovieEntity> getFiltered(MovieFilterDTO movieFilters){

        // Lambda Function:
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // == Title ==
            if(StringUtils.hasLength(movieFilters.getTitle())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("title")),
                                "%" + movieFilters.getTitle().toLowerCase() + "%"
                        )
                );
            }

            // == Characters ==
            if(!CollectionUtils.isEmpty(movieFilters.getCharacter())) {
                Join<MovieEntity, CharacterEntity> join = root.join("movieCharacters", JoinType.INNER);
                Expression<String> characterId = join.get("id");
                predicates.add(characterId.in(movieFilters.getCharacter()));
            }
            //Remove duplicates
            query.distinct(true);

            // == Order ==
            String orderByField = "title";
            query.orderBy(
                    movieFilters.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );


            // MAIN RETURN:
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
