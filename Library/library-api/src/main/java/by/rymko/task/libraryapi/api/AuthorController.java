package by.rymko.task.libraryapi.api;

import by.rymko.task.libraryapi.dto.AuthorDto;
import by.rymko.task.libraryapi.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("api/authors")
@CrossOrigin
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/all")
    public List<AuthorDto> getAllAuthors() {
        return this.authorService.getAllAuthors();
    }

    @GetMapping("/byId/{id}")
    public AuthorDto getAuthorById(@PathVariable long id) {
        return this.authorService.getAuthorById(id);
    }

    @PostMapping
    public AuthorDto saveUpdateAuthor(@RequestBody AuthorDto authorDto,
                                      BindingResult bindingResult) throws ValidationException {
        if (bindingResult.hasErrors()) throw new ValidationException("An error has occurred while saving an author");
        AuthorDto updatedAuthorDto = this.authorService.saveUpdateAuthor(authorDto);
        return updatedAuthorDto;
    }

    @DeleteMapping("/{id}")
    public void deleteAuthorById(@PathVariable long id) {
        this.authorService.deleteAuthorById(id);
    }
}
