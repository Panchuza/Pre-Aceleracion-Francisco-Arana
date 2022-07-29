package com.alkemy.projectDisney.projectDisney.services.impl;

import com.alkemy.projectDisney.projectDisney.dto.MovieBasicDTO;
import com.alkemy.projectDisney.projectDisney.dto.MovieDTO;
import com.alkemy.projectDisney.projectDisney.dto.MovieFilterDTO;
import com.alkemy.projectDisney.projectDisney.entities.CharacterEntity;
import com.alkemy.projectDisney.projectDisney.entities.MovieEntity;
import com.alkemy.projectDisney.projectDisney.exceptions.ParamNotFound;
import com.alkemy.projectDisney.projectDisney.mappers.MovieMapper;
import com.alkemy.projectDisney.projectDisney.repositories.MovieRepository;
import com.alkemy.projectDisney.projectDisney.repositories.specification.MovieSpecification;
import com.alkemy.projectDisney.projectDisney.services.CharacterService;
import com.alkemy.projectDisney.projectDisney.services.GenreService;
import com.alkemy.projectDisney.projectDisney.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    public MovieMapper movieMapper;
    @Autowired
    public MovieRepository movieRepository;
    @Autowired
    public CharacterService characterService;
    @Autowired
    public GenreService genreService;
    @Autowired
    private MovieSpecification movieSpecification;

    public MovieDTO save(MovieDTO dto){
        MovieEntity mEntity = movieMapper.movieDTO2Entity(dto, true);
        MovieEntity mEntitySaved = movieRepository.save(mEntity);
        MovieDTO result = movieMapper.movieEntity2DTO(mEntitySaved, false);

        return result;
    }

    public List<MovieDTO> getAllMovies() {
        List<MovieEntity> entities = movieRepository.findAll();
        List<MovieDTO> result = movieMapper.movieEntityList2MovieDTOList(entities, true);

        return result;
    }
//    public List<MovieBasicDTO> getAllMoviesAndCharacters() {
//        List<MovieEntity> entities = movieRepository.findAll();
//        List<MovieBasicDTO> result = movieMapper.movieEntityList2MovieBasicDTOList(entities, true);
//
//        return result;
//    }

    //@Transactional
    public void addCharacter(Long movieId, Long characterId) {
        MovieEntity movieEntity = this.getById(movieId);

        CharacterEntity character = characterService.getCharacterById(characterId);
        movieEntity.getCharacters().add(character);
        movieRepository.save(movieEntity);
    }

    public void addGenre(Long movieId, Long genreId) {
        MovieEntity movieEntity = this.getById(movieId);

        movieEntity.setGenreId(genreService.getGenreById(genreId).getId());
        movieRepository.save(movieEntity);
    }

    @Override
    public MovieEntity getById(Long id) {
        Optional<MovieEntity> movieEntity = movieRepository.findById(id);
        if (!movieEntity.isPresent()) {
            throw new ParamNotFound("Movie does not exist.");
        }
        return movieEntity.get();
    }

    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }

    public MovieDTO modify (Long id, MovieDTO moviedto){
        MovieEntity savedMovie = this.getById(id);

        savedMovie.setTitle(moviedto.getTitle());
        savedMovie.setImage(moviedto.getImage());
        savedMovie.setScore(moviedto.getScore());

        MovieEntity movieEntity = movieRepository.save(savedMovie);
        MovieDTO result = movieMapper.movieEntity2DTO(movieEntity, true);

        return result;
    }

    //PRUEBA CRITERIA
    @Override
    public List<MovieBasicDTO> getByFilters(String title, Set<Long> genre, String order) {
        MovieFilterDTO movieFilters = new MovieFilterDTO(title, genre, order);
        List<MovieEntity> entityList = movieRepository.findAll(movieSpecification.getFiltered(movieFilters));
        List<MovieBasicDTO> result = movieMapper.movieEntityList2MovieBasicDTOList(entityList, true);
        return result;
    }

    @Override
    @Transactional
    public void removeCharacter(Long id, Long idCharacter){
        MovieEntity movieEntity = this.getById(id);
        movieEntity.getCharacters();
        CharacterEntity character = this.characterService.getCharacterById(idCharacter);
        movieEntity.getCharacters().remove(character);
        this.movieRepository.save(movieEntity);
    }
}
