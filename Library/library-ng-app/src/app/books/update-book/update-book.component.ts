import { Component, OnInit } from '@angular/core';
import {Author} from "../../dto/author";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthorsApiService} from "../../service/authors-api.service";
import {Genre} from "../../dto/genre";
import {Book} from "../../dto/book";
import {BooksApiService} from "../../service/books-api.service";
import {GenresApiService} from "../../service/genres-api.service";

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {

  id: string;
  authorsDropdownList: Array<Author> = [];
  authorsDropdownSettings = {};

  genresList: Array<Genre> = [];


  book: Book = {
    id: '',
    title: '',
    authors: null,
    genre: null
  };

  constructor(private route: ActivatedRoute,
              private router: Router,
              private booksApiService: BooksApiService,
              private authorsApiService: AuthorsApiService,
              private genresApiService: GenresApiService) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.booksApiService.getBookById(this.id).subscribe(
      res => {
        this.book = res;
      },
      error => {
        alert("An error has occurred while getting book by ID.");
      }
    );
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

  updateBook() {
    this.booksApiService.addUpdateBook(this.book).subscribe(
      res => {
        this.router.navigate(['/books']);
      },
      err => {
        alert("An error has occurred while updating book.");
      }
    );
  }
}
