import {Component, OnInit} from '@angular/core';
import {City} from "../cities/model/city";
import {ApiService} from "../shared/api.service";

@Component({
  selector: 'app-guide',
  templateUrl: './guide.component.html',
  styleUrls: ['./guide.component.css']
})
export class GuideComponent implements OnInit {
  searchCityName: string;
  city: City;
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

  searchCity(searchCityName: string) {
    this.city = this.cities.find(c => c.name == searchCityName);
  }
}
