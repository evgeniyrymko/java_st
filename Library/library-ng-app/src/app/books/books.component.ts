import {Component, OnInit} from '@angular/core';
import {Book} from "../dto/book";
import {BooksApiService} from "../service/books-api.service";

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books: Book[] = [];

  constructor(private booksApiService: BooksApiService) {
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
}
