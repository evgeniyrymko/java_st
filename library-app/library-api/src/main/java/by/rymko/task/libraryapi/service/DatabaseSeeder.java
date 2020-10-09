package by.rymko.task.libraryapi.service;

import by.rymko.task.libraryapi.model.Author;
import by.rymko.task.libraryapi.model.Book;
import by.rymko.task.libraryapi.model.Genre;
import by.rymko.task.libraryapi.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "library-api.dbseeder", havingValue = "true")
public class DatabaseSeeder implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseSeeder.class);

    private BookRepository bookRepository;

    @Autowired
    public DatabaseSeeder(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Book book1 = new Book("Anna Karenina");
        Book book2 = new Book("Uchebnik istorii");
        Book book3 = new Book("Zolotaya rybka");

        Author author1 = new Author("Tolstoy");
        Author author2 = new Author("Pushkin");

        Genre genre1 = new Genre("Novel");
        Genre genre2 = new Genre("Uchebnik");

        book1.getAuthors().add(author1);
        book2.getAuthors().add(author1);
        book2.getAuthors().add(author2);
        book3.getAuthors().add(author2);

        book1.setGenre(genre1);
        book2.setGenre(genre2);
        book3.setGenre(genre1);

        author1.getBooks().add(book1);
        author1.getBooks().add(book2);
        author2.getBooks().add(book2);
        author2.getBooks().add(book3);

        genre1.getBooks().add(book1);
        genre1.getBooks().add(book3);
        genre2.getBooks().add(book2);

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);

        LOGGER.info("Database seeder successfully executed.");
    }
}
