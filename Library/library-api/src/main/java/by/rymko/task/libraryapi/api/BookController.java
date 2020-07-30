package by.rymko.task.libraryapi.api;

import by.rymko.task.libraryapi.model.Book;
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
    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    @GetMapping("/byId/{id}")
    public Book getBookById(@PathVariable long id) {
        return this.bookRepository.findById(id).get();
    }
}
