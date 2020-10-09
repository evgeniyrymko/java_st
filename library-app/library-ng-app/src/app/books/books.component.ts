import {Component, OnInit} from '@angular/core';
import {Book} from "../dto/book";
import {BooksApiService} from "../service/books-api.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books: Book[] = [];
  titleFilter: string;
  authorFilter: string;

  constructor(private booksApiService: BooksApiService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getAllBooks();
  }

  private getAllBooks() {
    this.booksApiService.getAllBooks().subscribe(
      res => {
        this.books = res;
      },
      error => {
        alert("An error has occurred while getting all books.");
        location.reload();
      }
    );
  }

  deleteBook(book: Book) {
    if (confirm("Are you sure you want to delete " + book.title + "?")) {
      this.booksApiService.deleteBook(book.id).subscribe(
        res => {
          let indexOfBook = this.books.indexOf(book);
          this.books.splice(indexOfBook, 1);
        },
        error => {
          alert("An error has occurred while deleting a book.")
        }
      );
    }
  }

  updateBook(book: Book) {
    this.router.navigate(['books-update', book.id]);
  }
}
