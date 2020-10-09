import {Author} from "./author";
import {Genre} from "./genre";

export interface Book {
  id: string;
  title: string;
  authors: Array<Author>;
  genre: Genre;
}
