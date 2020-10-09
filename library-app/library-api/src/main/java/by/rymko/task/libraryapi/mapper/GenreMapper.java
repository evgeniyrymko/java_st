package by.rymko.task.libraryapi.mapper;

import by.rymko.task.libraryapi.dto.GenreDto;
import by.rymko.task.libraryapi.model.Genre;
import by.rymko.task.libraryapi.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GenreMapper {

    private GenreRepository genreRepository;

    @Autowired
    public GenreMapper(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public GenreDto convertToGenreDto(Genre genre) {
        GenreDto genreDto = new GenreDto();
        genreDto.setId(genre.getId().toString());
        genreDto.setName(genre.getName());

        return genreDto;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Genre convertToGenre(GenreDto genreDto) {
        Genre genre = new Genre();
        if (genreDto.getId() != null && !genreDto.getId().isEmpty()) {
            genre = genreRepository.findById(Long.parseLong(genreDto.getId())).get();
        }
        genre.setName(genreDto.getName());
        return genre;
    }
}
