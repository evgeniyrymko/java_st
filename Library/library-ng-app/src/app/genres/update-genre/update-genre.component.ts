import {Component, OnInit} from '@angular/core';
import {Author} from "../../dto/author";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthorsApiService} from "../../service/authors-api.service";
import {Genre} from "../../dto/genre";
import {GenresApiService} from "../../service/genres-api.service";

@Component({
  selector: 'app-update-genre',
  templateUrl: './update-genre.component.html',
  styleUrls: ['./update-genre.component.css']
})
export class UpdateGenreComponent implements OnInit {


  id: string;
  genre: Genre = {
    id: '',
    name: ''
  };

  constructor(private route: ActivatedRoute,
              private router: Router,
              private genresApiService: GenresApiService) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.genresApiService.getGenreById(this.id).subscribe(
      res => {
        this.genre = res;
      },
      error => {
        alert("An error has occurred while getting genre by ID.");
      }
    );
  }

  updateGenre() {
    this.genresApiService.addUpdateGenre(this.genre).subscribe(
      res => {
        this.router.navigate(['/genres']);
      },
      err => {
        alert("An error has occurred while updating genre.");
      }
    );
  }
}
