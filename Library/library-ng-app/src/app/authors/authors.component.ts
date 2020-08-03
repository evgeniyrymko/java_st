import {Component, OnInit} from '@angular/core';
import {Author} from "../dto/author";
import {AuthorsApiService} from "../service/authors-api.service";

@Component({
  selector: 'app-authors',
  templateUrl: './authors.component.html',
  styleUrls: ['./authors.component.css']
})
export class AuthorsComponent implements OnInit {
  authors: Author[] = [];

  constructor(private authorsApiService: AuthorsApiService) {
  }

  ngOnInit(): void {
    this.getAllAuthors();
  }

  private getAllAuthors() {
    this.authorsApiService.getAllAuthors().subscribe(
      res => {
        this.authors = res;
      },
      error => {
        alert("An error has occurred while getting all authors.")
      }
    );
  }
}
