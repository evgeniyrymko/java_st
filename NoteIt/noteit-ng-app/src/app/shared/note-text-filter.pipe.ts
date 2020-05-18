import {Pipe, PipeTransform} from '@angular/core';
import {Note} from "../notes/model/note";

@Pipe({
  name: 'noteTextFilter'
})
export class NoteTextFilterPipe implements PipeTransform {

  transform(notes: Note[], filter: string): Note[] {
    if (filter == null || filter === "") {
      return notes;
    }
    return notes.filter(n => n.title.toLowerCase().includes(filter.toLowerCase()) || n.text.toLowerCase().includes(filter.toLowerCase()));
  }

}

