import {Component, OnInit} from '@angular/core';
import {Author} from "../../dto/author";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthorsApiService} from "../../service/authors-api.service";

@Component({
  selector: 'app-update-author',
  templateUrl: './update-author.component.html',
  styleUrls: ['./update-author.component.css']
})
export class UpdateAuthorComponent implements OnInit {

  id: string;
  author: Author = {
    id: '',
    name: ''
  };

  constructor(private route: ActivatedRoute,
              private router: Router,
              private authorsApiService: AuthorsApiService) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.authorsApiService.getAuthorById(this.id).subscribe(
      res => {
        this.author = res;
      },
      error => {
        alert("An error has occurred while getting author by ID.");
      }
    );
  }

  updateAuthor() {
    this.authorsApiService.addUpdateAuthor(this.author).subscribe(
      res => {
        this.router.navigate(['/authors']);
      },
      err => {
        alert("An error has occurred while updating author.");
      }
    );
  }
}
