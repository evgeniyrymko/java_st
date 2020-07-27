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
  currentCity: City;

  constructor(private apiService: ApiService) {
  }

  ngOnInit(): void {
    this.getAllCities();
  }

  selectCity(city: City) {
    this.currentCity = city;
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
      res => {

      },
      error => {
        alert("An error has occurred while updating a city.");
        location.reload();
      }
    );
  }

  updateCityDescription(currentCity: City) {
    if (currentCity.cityDescription.length < 10) {
      alert("City description should contain at least 10 characters.");
      location.reload();
    } else {
      this.apiService.updateCityDescription(currentCity).subscribe(
        res => {
        },
        error => {
          alert("An error has occurred while updating a city description.");
        }
      );
    }
  }

  deleteCity(city: City) {
    if (confirm("Are you sure you want to delete " + city.name + " city?")) {
      this.apiService.deleteCity(city.id).subscribe(
        res => {
          let indexOfCity = this.cities.indexOf(city);
          this.cities.splice(indexOfCity, 1);
        },
        error => {
          alert("An error has occurred while deleting a city.");
        }
      );
    }
  }
}
