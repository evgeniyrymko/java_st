import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Author} from "../dto/author";

@Injectable({
  providedIn: 'root'
})
export class AuthorsApiService {

  constructor(private http: HttpClient) {
  }

  private BASE_URL = "http://localhost:8085/api/";
  private ALL_AUTHORS_URL = `${this.BASE_URL}/authors/all`;
  private ADD_UPDATE_AUTHOR_URL = `${this.BASE_URL}/authors`;
  private DELETE_UPDATE_AUTHOR_URL = `${this.BASE_URL}/authors/`;

  getAllAuthors(): Observable<Author[]> {
    return this.http.get<Author[]>(this.ALL_AUTHORS_URL);
  }

  addUpdateAuthor(author: Author): Observable<Author> {
    return this.http.post<Author>(this.ADD_UPDATE_AUTHOR_URL, author);
  }

  deleteAuthor(id: string): Observable<any> {
    return this.http.delete(this.DELETE_UPDATE_AUTHOR_URL + id);
  }
}
