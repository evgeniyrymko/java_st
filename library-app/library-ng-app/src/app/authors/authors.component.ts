import {Component, OnInit} from '@angular/core';
import {Author} from "../dto/author";
import {AuthorsApiService} from "../service/authors-api.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-authors',
  templateUrl: './authors.component.html',
  styleUrls: ['./authors.component.css']
})
export class AuthorsComponent implements OnInit {
  authors: Author[] = [];

  constructor(private authorsApiService: AuthorsApiService,
              private router: Router) {
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

  deleteAuthor(author: Author) {
    if (confirm("Are you sure you want to delete " + author.name + "?")) {
      this.authorsApiService.deleteAuthor(author.id).subscribe(
        res => {
          let indexOfAuthor = this.authors.indexOf(author);
          this.authors.splice(indexOfAuthor, 1);
        },
        error => {
          alert("An error has occurred while deleting an author.")
        }
      );
    }
  }

  updateAuthor(author: Author) {
    this.router.navigate(['authors-update', author.id]);
  }
}
