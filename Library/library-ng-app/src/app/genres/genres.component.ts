import {Component, OnInit} from '@angular/core';
import {Genre} from "../dto/genre";
import {GenresApiService} from "../service/genres-api.service";

@Component({
  selector: 'app-genres',
  templateUrl: './genres.component.html',
  styleUrls: ['./genres.component.css']
})
export class GenresComponent implements OnInit {

  genres: Genre[] = [];

  constructor(private genresApiService: GenresApiService) {
  }

  ngOnInit(): void {
    this.getAllGenres();
  }

  private getAllGenres() {
    this.genresApiService.getAllGenres().subscribe(
      res => {
        this.genres = res;
      },
      error => {
        alert("An error has occurred while getting all genres.");
      }
    );
  }
}
