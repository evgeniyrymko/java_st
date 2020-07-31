package by.rymko.task.libraryapi.service;

import by.rymko.task.libraryapi.dto.BookDto;
import by.rymko.task.libraryapi.mapper.BookMapper;
import by.rymko.task.libraryapi.model.Book;
import by.rymko.task.libraryapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;

    private BookMapper bookMapper;

    @Autowired
    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<BookDto> getAllBooks() {
        List<Book> allBooks = this.bookRepository.findAll();
        List<BookDto> allBooksDto = allBooks.stream()
                .map(book -> this.bookMapper.convertToBookDto(book))
                .collect(Collectors.toList());
        return allBooksDto;
    }

    public BookDto getBookById(long id) {
        Book bookById = bookRepository.findById(id).get();
        BookDto bookDtoById = this.bookMapper.convertToBookDto(bookById);
        return bookDtoById;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public BookDto saveUpdateBook(BookDto bookDto) {
        Book book = this.bookMapper.convertToBook(bookDto);
        Book updatedBook = bookRepository.save(book);
        BookDto updatedBookDto = this.bookMapper.convertToBookDto(updatedBook);
        return updatedBookDto;
    }

    @Transactional
    public void deleteBookById(long id) {
        this.bookRepository.deleteById(id);
    }
}
