import {Component, OnInit} from '@angular/core';
import {ApiService} from "../shared/api.service";
import {City} from "../cities/model/city";

@Component({
  selector: 'app-new-city',
  templateUrl: './new-city.component.html',
  styleUrls: ['./new-city.component.css']
})
export class NewCityComponent implements OnInit {
  model: City = {
    id: '',
    name: '',
    cityDescription: ''
  };

  constructor(private apiService: ApiService) {
  }

  ngOnInit(): void {
  }

  addNewCity(): void {
    this.apiService.addNewCity(this.model).subscribe(
      res => {
        location.reload();
      },
      error => {
        alert("An error has occurred while adding new city.")
      }
    );
  }

}
