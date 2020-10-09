package by.rymko.task.libraryapi.mapper;

import by.rymko.task.libraryapi.dto.AuthorDto;
import by.rymko.task.libraryapi.model.Author;
import by.rymko.task.libraryapi.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AuthorMapper {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorMapper(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorDto convertToAuthorDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId().toString());
        authorDto.setName(author.getName());
        return authorDto;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Author convertToAuthor(AuthorDto authorDto) {
        Author author = new Author();
        if (authorDto.getId() != null && !authorDto.getId().isEmpty()) {
            author = authorRepository.findById(Long.parseLong(authorDto.getId())).get();
        }
        author.setName(authorDto.getName());
        return author;
    }
}
