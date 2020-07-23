import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {City} from "../cities/model/city";

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private BASE_URL = "http://localhost:8085/api/";
  private ALL_CITIES_URL = `${this.BASE_URL}/cities/all`;
  private ADD_NEW_CITY_URL = `${this.BASE_URL}/cities/new`;
  private UPDATE_CITY_URL = `${this.BASE_URL}/cities/update-city`;

  constructor(private http: HttpClient) {
  }

  getAllCities(): Observable<City[]> {
    return this.http.get<City[]>(this.ALL_CITIES_URL);
  }

  addNewCity(city: City): Observable<City> {
    return this.http.post<City>(this.ADD_NEW_CITY_URL, city);
  }

  updateCity(updatedCity: City): Observable<City> {
    return this.http.post<City>(this.UPDATE_CITY_URL, updatedCity);
  }
}

