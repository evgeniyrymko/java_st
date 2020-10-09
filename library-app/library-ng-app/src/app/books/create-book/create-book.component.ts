import {Component, OnInit} from '@angular/core';
import {Book} from "../../dto/book";
import {Author} from "../../dto/author";
import {Genre} from "../../dto/genre";
import {BooksApiService} from "../../service/books-api.service";
import {AuthorsApiService} from "../../service/authors-api.service";
import {GenresApiService} from "../../service/genres-api.service";

@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.css']
})
export class CreateBookComponent implements OnInit {

  authorsDropdownList: Array<Author> = [];
  authorsDropdownSettings = {};

  genresList: Array<Genre> = [];


  newBook: Book = {
    id: '',
    title: '',
    authors: null,
    genre: null
  };

  constructor(private booksApiService: BooksApiService,
              private authorsApiService: AuthorsApiService,
              private genresApiService: GenresApiService) {
  }

  ngOnInit(): void {
    this.authorsApiService.getAllAuthors().subscribe(
      res => {
        this.authorsDropdownList = res;
      },
      error => {
        alert("An error has occurred while getting all authors.")
      }
    );
    this.genresApiService.getAllGenres().subscribe(
      res => {
        this.genresList = res;
      },
      error => {
        alert("An error has occurred while getting all genres.")
      }
    );
    this.authorsDropdownSettings = {
      singleSelection: false,
      idField: 'id',
      textField: 'name',
      selectAllText: 'Select All',
      unSelectAllText: 'unSelect All',
      itemsShowLimit: 5,
      allowSearchFilter: false
    };
  }

  addNewBook(): void {
    this.booksApiService.addUpdateBook(this.newBook).subscribe(
      res => {
        location.reload();
      },
      err => {
        alert("An error has occurred while adding new book.");
      }
    );
  }
}
