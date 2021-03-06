import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Genre} from "../dto/genre";
import {Author} from "../dto/author";

@Injectable({
  providedIn: 'root'
})
export class GenresApiService {

  constructor(private http: HttpClient) {
  }

  private BASE_URL = "http://localhost:8085/api/";
  private ALL_GENRES_URL = `${this.BASE_URL}/genres/all`;
  private ADD_UPDATE_GENRE_URL = `${this.BASE_URL}/genres`;
  private DELETE_UPDATE_GENRE_URL = `${this.BASE_URL}/genres/`;
  private GET_GENRE_BY_ID_URL = `${this.BASE_URL}/genres/byId/`;

  getAllGenres(): Observable<Genre[]> {
    return this.http.get<Genre[]>(this.ALL_GENRES_URL);
  }

  addUpdateGenre(genre: Genre): Observable<Genre> {
    return this.http.post<Genre>(this.ADD_UPDATE_GENRE_URL, genre);
  }

  deleteGenre(id: string): Observable<any> {
    return this.http.delete(this.DELETE_UPDATE_GENRE_URL + id);
  }

  getGenreById(id: string): Observable<Genre> {
    return this.http.get<Genre>(this.GET_GENRE_BY_ID_URL + id);
  }
}
