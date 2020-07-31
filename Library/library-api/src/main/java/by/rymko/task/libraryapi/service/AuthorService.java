package by.rymko.task.libraryapi.service;

import by.rymko.task.libraryapi.dto.AuthorDto;
import by.rymko.task.libraryapi.mapper.AuthorMapper;
import by.rymko.task.libraryapi.model.Author;
import by.rymko.task.libraryapi.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    private AuthorMapper authorMapper;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public List<AuthorDto> getAllAuthors() {
        List<Author> allAuthors = this.authorRepository.findAll();
        List<AuthorDto> allAuthorsDto = allAuthors.stream()
                .map(author -> this.authorMapper.convertToAuthorDto(author))
                .collect(Collectors.toList());
        return allAuthorsDto;
    }

    public AuthorDto getAuthorById(long id) {
        Author authorById = authorRepository.findById(id).get();
        AuthorDto authorDtoById = this.authorMapper.convertToAuthorDto(authorById);
        return authorDtoById;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public AuthorDto saveUpdateAuthor(AuthorDto authorDto) {
        Author author = this.authorMapper.convertToAuthor(authorDto);
        Author updatedAuthor = authorRepository.save(author);
        AuthorDto updatedAuthorDto = this.authorMapper.convertToAuthorDto(updatedAuthor);
        return updatedAuthorDto;
    }

    @Transactional
    public void deleteAuthorById(long id) {
        this.authorRepository.deleteById(id);
    }
}
