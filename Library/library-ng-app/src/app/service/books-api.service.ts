import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Book} from "../dto/book";

@Injectable({
  providedIn: 'root'
})
export class BooksApiService {

  constructor(private http: HttpClient) {
  }

  private BASE_URL = "http://localhost:8085/api/";
  private ALL_BOOKS_URL = `${this.BASE_URL}/books/all`;

  getAllBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(this.ALL_BOOKS_URL);
  }

}
