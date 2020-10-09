package by.rymko.task.libraryapi.service;

import by.rymko.task.libraryapi.dto.GenreDto;
import by.rymko.task.libraryapi.mapper.GenreMapper;
import by.rymko.task.libraryapi.model.Genre;
import by.rymko.task.libraryapi.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {


    private GenreRepository genreRepository;

    private GenreMapper genreMapper;

    @Autowired
    public GenreService(GenreRepository genreRepository, GenreMapper genreMapper) {
        this.genreRepository = genreRepository;
        this.genreMapper = genreMapper;
    }

    public List<GenreDto> getAllGenres() {
        List<Genre> allGenres = this.genreRepository.findAll();
        List<GenreDto> allGenresDto = allGenres.stream()
                .map(genre -> this.genreMapper.convertToGenreDto(genre))
                .collect(Collectors.toList());
        return allGenresDto;
    }

    public GenreDto getGenreById(long id) {
        Genre genreById = genreRepository.findById(id).get();
        GenreDto genreDtoById = this.genreMapper.convertToGenreDto(genreById);
        return genreDtoById;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public GenreDto saveUpdateGenre(GenreDto genreDto) {
        Genre genre = this.genreMapper.convertToGenre(genreDto);
        Genre updatedGenre = genreRepository.save(genre);
        GenreDto updatedGenreDto = this.genreMapper.convertToGenreDto(updatedGenre);
        return updatedGenreDto;
    }

    @Transactional
    public void deleteGenreById(long id) {
        this.genreRepository.deleteById(id);
    }
}
