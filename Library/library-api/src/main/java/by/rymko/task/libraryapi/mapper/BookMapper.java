package by.rymko.task.libraryapi.mapper;

import by.rymko.task.libraryapi.dto.BookDto;
import by.rymko.task.libraryapi.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BookMapper {

    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private GenreMapper genreMapper;

    public BookDto convertToBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId().toString());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthors(book.getAuthors().stream()
                .map(author -> this.authorMapper.convertToAuthorDto(author))
                .collect(Collectors.toSet()));
        bookDto.setGenre(this.genreMapper.convertToGenreDto(book.getGenre()));
        return bookDto;
    }

    public Book convertToBook(BookDto bookDto) {
        Book book = new Book();
        if (bookDto.getId() != null && !bookDto.getId().isEmpty()) book.setId(Long.parseLong(bookDto.getId()));
        book.setTitle(bookDto.getTitle());
        book.setAuthors(bookDto.getAuthors().stream()
                .map(authorDto -> this.authorMapper.convertToAuthor(authorDto))
                .collect(Collectors.toSet()));
        book.setGenre(this.genreMapper.convertToGenre(bookDto.getGenre()));
        return book;
    }
}
