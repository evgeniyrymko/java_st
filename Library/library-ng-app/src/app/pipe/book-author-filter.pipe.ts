import { Pipe, PipeTransform } from '@angular/core';
import {Book} from "../dto/book";

@Pipe({
  name: 'bookAuthorFilter'
})
export class BookAuthorFilterPipe implements PipeTransform {

  transform(books: Book[], text: String): Book[] {
    if (text == null || text === "") {
      return books;
    }

    // return books.filter(n => n.genre.name.toLowerCase().includes(text.toLowerCase()));
  }

}
