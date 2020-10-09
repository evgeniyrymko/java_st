package by.rymko.task.libraryapi.api;

import by.rymko.task.libraryapi.dto.BookDto;
import by.rymko.task.libraryapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("api/books")
@CrossOrigin
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public List<BookDto> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/byId/{id}")
    public BookDto getBookById(@PathVariable long id) {
        return this.bookService.getBookById(id);
    }

    @PostMapping
    public BookDto saveUpdateBook(@RequestBody BookDto bookDto,
                                  BindingResult bindingResult) throws ValidationException {
        if (bindingResult.hasErrors()) throw new ValidationException("An error has occurred while saving a book");
        BookDto updatedBookDto = this.bookService.saveUpdateBook(bookDto);
        return updatedBookDto;
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable long id) {
        this.bookService.deleteBookById(id);
    }
}

