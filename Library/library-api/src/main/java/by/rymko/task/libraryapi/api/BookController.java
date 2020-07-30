package by.rymko.task.libraryapi.api;

import by.rymko.task.libraryapi.dto.BookDto;
import by.rymko.task.libraryapi.repository.BookRepository;
import by.rymko.task.libraryapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
@CrossOrigin
public class BookController {

    private BookService bookService;

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/all")
    public List<BookDto> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/byId/{id}")
    public BookDto getBookById(@PathVariable long id) {
        return this.bookService.getBookById(id);
    }
}
