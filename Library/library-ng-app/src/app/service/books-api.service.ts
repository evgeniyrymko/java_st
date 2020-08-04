import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Book} from "../dto/book";
import {Genre} from "../dto/genre";

@Injectable({
  providedIn: 'root'
})
export class BooksApiService {

  constructor(private http: HttpClient) {
  }

  private BASE_URL = "http://localhost:8085/api/";
  private ALL_BOOKS_URL = `${this.BASE_URL}/books/all`;
  private ADD_UPDATE_BOOK_URL = `${this.BASE_URL}/books`;
  private DELETE_UPDATE_BOOK_URL = `${this.BASE_URL}/books/`;

  getAllBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(this.ALL_BOOKS_URL);
  }

  addUpdateBook(book: Book): Observable<Book> {
    return this.http.post<Book>(this.ADD_UPDATE_BOOK_URL, book);
  }

  deleteBook(id: string): Observable<any> {
    return this.http.delete(this.DELETE_UPDATE_BOOK_URL + id);
  }
}
