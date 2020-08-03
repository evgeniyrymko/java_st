import {Component, OnInit} from '@angular/core';
import {Author} from "../../dto/author";
import {AuthorsApiService} from "../../service/authors-api.service";

@Component({
  selector: 'app-create-author',
  templateUrl: './create-author.component.html',
  styleUrls: ['./create-author.component.css']
})
export class CreateAuthorComponent implements OnInit {

  newAuthor: Author = {
    id: '',
    name: '',
  };

  constructor(private authorsApiService: AuthorsApiService) {
  }

  ngOnInit(): void {
  }

  addNewAuthor(): void {
    this.authorsApiService.addUpdateAuthor(this.newAuthor).subscribe(
      res =>{
        location.reload();
      },
      err =>{
        alert("An error has occurred while adding new author.");
      }
    );
  }

}
