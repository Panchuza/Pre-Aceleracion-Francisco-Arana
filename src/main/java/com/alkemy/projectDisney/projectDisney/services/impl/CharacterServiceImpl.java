package com.alkemy.projectDisney.projectDisney.services.impl;

import com.alkemy.projectDisney.projectDisney.dto.CharacterDTO;
import com.alkemy.projectDisney.projectDisney.dto.CharacterFilterDTO;
import com.alkemy.projectDisney.projectDisney.entities.CharacterEntity;
import com.alkemy.projectDisney.projectDisney.entities.MovieEntity;
import com.alkemy.projectDisney.projectDisney.exceptions.ParamNotFound;
import com.alkemy.projectDisney.projectDisney.mappers.CharacterMapper;
import com.alkemy.projectDisney.projectDisney.mappers.MovieMapper;
import com.alkemy.projectDisney.projectDisney.repositories.CharacterRepository;
import com.alkemy.projectDisney.projectDisney.repositories.specification.CharacterSpecification;
import com.alkemy.projectDisney.projectDisney.services.CharacterService;
import com.alkemy.projectDisney.projectDisney.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    CharacterMapper characterMapper;
    @Autowired
    CharacterRepository characterRepository;
    @Autowired
    CharacterSpecification characterSpecification;
    @Autowired
    MovieMapper movieMapper;
    @Lazy
    @Autowired
    private MovieService movieService;

    public List<CharacterDTO> getAllCharacters() {
        List<CharacterEntity> entities = characterRepository.findAll();
        List<CharacterDTO> result = characterMapper.characterEntityList2DTOList(entities, true);

        return result;
    }

    public CharacterDTO save(CharacterDTO dto) {

        CharacterEntity cEntity = characterMapper.characterDTO2Entity(dto);
        CharacterEntity cEntitySaved = characterRepository.save(cEntity);
        CharacterDTO result = characterMapper.characterEntity2DTO(cEntitySaved, false);

        return result;
    }
//PRUEBA
    @Override
    public CharacterEntity getCharacterById(Long id) {
        Optional<CharacterEntity> characterEntity = characterRepository.findById(id);
        if (!characterEntity.isPresent()) {
            throw new ParamNotFound("This Disney character does not exist."+ id);
        }
        return characterEntity.get();
    }

    @Override
    public void addMovie(Long id, Long idMovie) {
        CharacterEntity charEntity = this.getCharacterById(id);
        charEntity.getMovies().size();
        MovieEntity movie = this.movieService.getById(idMovie);
        charEntity.getMovies().add(movie);
        this.characterRepository.save(charEntity);
    }

    @Override
    @Transactional
    public void removeMovie(Long id, Long idMovie) {
        CharacterEntity charEntity = this.getCharacterById(id);
        charEntity.getMovies();
        MovieEntity movie = this.movieService.getById(idMovie);
        charEntity.getMovies().remove(movie);
        this.characterRepository.save(charEntity);
    }

    @Override
    public void delete(Long id) {

        characterRepository.deleteById(id);
    }

    public CharacterDTO modify (Long id, CharacterDTO characterDTO) {
        CharacterEntity savedCharacter = this.getCharacterById(id);

        savedCharacter.setName(characterDTO.getName());
        savedCharacter.setImage(characterDTO.getImage());
        savedCharacter.setHistory(characterDTO.getHistory());
        savedCharacter.setWeight(savedCharacter.getWeight());
        savedCharacter.setAge(characterDTO.getAge());

        //savedCharacter.setMovies(movieMapper.movieEntityList2MovieDTOList(characterDTO));

        CharacterEntity characterEntity = characterRepository.save(savedCharacter);
        CharacterDTO result = characterMapper.characterEntity2DTO(characterEntity, false);

        return result;
    }

    public List<CharacterDTO> getByFilters(String name, Set<Long> movies, Integer age){

        CharacterFilterDTO characterFilters = new CharacterFilterDTO(name, movies, age);
        List<CharacterEntity> entityList = characterRepository.findAll(characterSpecification.getFiltered(characterFilters));
        List<CharacterDTO> result = characterMapper.characterEntityList2DTOList(entityList, true);
        return result;
    }
}
