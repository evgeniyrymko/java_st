package by.rymko.task.libraryapi.mapper;

import by.rymko.task.libraryapi.dto.GenreDto;
import by.rymko.task.libraryapi.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {

    @Autowired
    private BookMapper bookMapper;

    public GenreDto convertToGenreDto(Genre genre) {
        GenreDto genreDto = new GenreDto();
        genreDto.setId(genre.getId().toString());
        genreDto.setName(genre.getName());
//        genreDto.setBooks(genre.getBooks().stream()
//                .map(book -> this.bookMapper.convertToBookDto(book))
//                .collect(Collectors.toSet()));
        return genreDto;
    }

    public Genre convertToGenre(GenreDto genreDto) {
        Genre genre = new Genre();
        //noinspection DuplicatedCode
        if (genreDto.getId() != null && !genreDto.getId().isEmpty()) genre.setId(Long.parseLong(genreDto.getId()));
        genre.setName(genreDto.getName());
//        genre.setBooks(genreDto.getBooks().stream()
//                .map(bookDto -> this.bookMapper.convertToBook(bookDto))
//                .collect(Collectors.toSet()));
        return genre;
    }
}
