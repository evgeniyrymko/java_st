import {Component, OnInit} from '@angular/core';
import {City} from "./model/city";
import {ApiService} from "../shared/api.service";

@Component({
  selector: 'app-cities',
  templateUrl: './cities.component.html',
  styleUrls: ['./cities.component.css']
})
export class CitiesComponent implements OnInit {
  cities: City[] = [];

  constructor(private apiService: ApiService) {
  }

  ngOnInit(): void {
    this.getAllCities();
  }

  public getAllCities() {
    this.apiService.getAllCities().subscribe(
      res => {
        this.cities = res;
      },
      error => {
        alert("An error has occurred while getting all cities.");
      }
    );
  }

  updateCity(updatedCity: City) {
    this.apiService.updateCity(updatedCity).subscribe(
      res =>{

      },
      error => {
        alert("An error has occurred while updating a city.");
        location.reload();
      }
    );

  }
}
