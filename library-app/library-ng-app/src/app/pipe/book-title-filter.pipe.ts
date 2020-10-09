import {Pipe, PipeTransform} from '@angular/core';
import {Book} from "../dto/book";

@Pipe({
  name: 'bookTitleFilter'
})
export class BookTitleFilterPipe implements PipeTransform {

  transform(books: Book[], text: String): Book[] {
    if (text == null || text === "") {
      return books;
    }
    return books.filter(n => n.title.toLowerCase().includes(text.toLowerCase()));
  }

}
