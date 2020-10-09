import { Component, OnInit } from '@angular/core';
import {Genre} from "../../dto/genre";
import {GenresApiService} from "../../service/genres-api.service";

@Component({
  selector: 'app-create-genre',
  templateUrl: './create-genre.component.html',
  styleUrls: ['./create-genre.component.css']
})
export class CreateGenreComponent implements OnInit {

  newGenre: Genre = {
    id: '',
    name: ''
  };

  constructor(private genresApiService: GenresApiService) { }

  ngOnInit(): void {
  }

  addNewGenre(): void {
    this.genresApiService.addUpdateGenre(this.newGenre).subscribe(
      res =>{
        location.reload();
      },
      err =>{
        alert("An error has occurred while adding new genre.");
      }
    );
  }

}
