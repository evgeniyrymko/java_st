package by.rymko.task.libraryapi.mapper;

import by.rymko.task.libraryapi.dto.BookDto;
import by.rymko.task.libraryapi.model.Author;
import by.rymko.task.libraryapi.model.Book;
import by.rymko.task.libraryapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Component
public class BookMapper {

    private AuthorMapper authorMapper;

    private GenreMapper genreMapper;

    private BookRepository bookRepository;

    @Autowired
    public BookMapper(AuthorMapper authorMapper, GenreMapper genreMapper, BookRepository bookRepository) {
        this.authorMapper = authorMapper;
        this.genreMapper = genreMapper;
        this.bookRepository = bookRepository;
    }

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

    @Transactional(propagation = Propagation.REQUIRED)
    public Book convertToBook(BookDto bookDto) {
        Book book = new Book();
        if (bookDto.getId() != null && !bookDto.getId().isEmpty()) {
            book = bookRepository.findById(Long.parseLong(bookDto.getId())).get();
        }
        book.setTitle(bookDto.getTitle());

        book.setAuthors(bookDto.getAuthors().stream()
                .map(authorDto -> this.authorMapper.convertToAuthor(authorDto))
                .collect(Collectors.toSet()));
        for (Author author : book.getAuthors()) {
            author.getBooks().add(book);
        }
        book.setGenre(this.genreMapper.convertToGenre(bookDto.getGenre()));
        book.getGenre().getBooks().add(book);
        return book;
    }
}
