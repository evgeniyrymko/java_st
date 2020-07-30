package by.rymko.task.libraryapi.mapper;

import by.rymko.task.libraryapi.dto.AuthorDto;
import by.rymko.task.libraryapi.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AuthorMapper {

    @Autowired
    private BookMapper bookMapper;

    public AuthorDto convertToAuthorDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId().toString());
        authorDto.setName(author.getName());
        authorDto.setBooks(author.getBooks().stream()
                .map(book -> this.bookMapper.convertToBookDto(book))
                .collect(Collectors.toSet()));
        return authorDto;
    }

    public Author convertToAuthor(AuthorDto authorDto) {
        Author author = new Author();
        //noinspection DuplicatedCode
        if (authorDto.getId() != null && !authorDto.getId().isEmpty()) author.setId(Long.parseLong(authorDto.getId()));
        author.setName(authorDto.getName());
        author.setBooks(authorDto.getBooks().stream().map(bookDto -> this.bookMapper
                .convertToBook(bookDto))
                .collect(Collectors.toSet()));
        return author;
    }
}
