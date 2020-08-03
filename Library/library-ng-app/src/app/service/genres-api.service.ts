import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Genre} from "../dto/genre";

@Injectable({
  providedIn: 'root'
})
export class GenresApiService {

  constructor(private http: HttpClient) {
  }

  private BASE_URL = "http://localhost:8085/api/";
  private ALL_GENRES_URL = `${this.BASE_URL}/genres/all`;
  private ADD_UPDATE_GENRE_URL = `${this.BASE_URL}/genres`;

  getAllGenres(): Observable<Genre[]> {
    return this.http.get<Genre[]>(this.ALL_GENRES_URL);
  }

  addUpdateGenre(genre: Genre): Observable<Genre> {
    return this.http.post<Genre>(this.ADD_UPDATE_GENRE_URL, genre);
  }
}
