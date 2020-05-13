import {Component, OnInit} from '@angular/core';
import {Notebook} from "./model/notebook";
import {ApiService} from "../shared/api.service";
import {Note} from "./model/note";

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent implements OnInit {
  notebooks: Notebook[] = [];
  notes: Note[] = [];
  selectedNotebook: Notebook;

  constructor(private apiService: ApiService) {
  }

  ngOnInit(): void {
    this.getAllNotebooks();
    this.getAllNotes();
  }

  public getAllNotebooks() {
    this.apiService.getAllNotebooks().subscribe(
      res => {
        this.notebooks = res;
      },
      err => {
        alert("An error has occurred during getting all notebooks");
      }
    );
  }

  public getAllNotes() {
    this.apiService.getAllNotes().subscribe(
      res => {
        this.notes = res;
      },
      err => {
        alert("An error has occurred during getting all notes");
      }
    );
  }

  public createNotebook() {
    let newNotebook: Notebook = {
      name: 'New Notebook',
      id: null,
      nbNotes: 0
    }
    this.apiService.postNotebook(newNotebook).subscribe(
      res => {
        newNotebook.id = res.id;
        this.notebooks.push(newNotebook);
      },
      err => {
        alert("An error has occurred during adding new notebook");
      }
    );
  }

  public updateNotebook(updatedNotebook: Notebook) {
    this.apiService.postNotebook(updatedNotebook).subscribe(
      res => {
      },
      err => {
        alert("An error has occurred during updating (changing) the notebook");
      }
    );
  }

  public deleteNotebook(notebook: Notebook) {
    if (confirm("Are you sure you want to delete the notebook?")) {
      this.apiService.deleteNotebook(notebook.id).subscribe(
        res => {
          let indexOfNotebook = this.notebooks.indexOf(notebook);
          this.notebooks.splice(indexOfNotebook, 1);
        },
        err => {
          alert("An error has occurred during deleting the notebook");
        }
      );
    }
  }

  public deleteNote(note: Note) {
    if (confirm("Are you sure you want to delete this note?")) {
      this.apiService.deleteNote(note.id).subscribe(
        res => {
          let indexOfNote = this.notes.indexOf(note);
          this.notes.splice(indexOfNote, 1);
        },
        err => {
          alert("An error has occurred during deleting the note");
        },
      );
    }
  }

  public createNote(notebookId: string) {
    let newNote: Note = {
      id: null,
      title: "New Note",
      text: "Write here your text",
      notebookId: notebookId,
      lastModifiedOn: null
    }
    this.apiService.postNote(newNote).subscribe(
      res => {
        newNote.id = res.id;
        this.notes.push(newNote);
      },
      err => {
        alert("An error has occurred during creating a new note");
      }
    );
  }

  public selectNotebook(notebook: Notebook) {
    this.selectedNotebook = notebook;
    this.apiService.getNotesByNotebook(notebook.id).subscribe(
      res => {
        this.notes = res;
      },
      err => {
        alert("An error has occurred during filtering the notes of selected notebook");
      },
    );
  }

  public updateNote(updatedNote: Note) {
    this.apiService.postNote(updatedNote).subscribe(
      res => {
      },
      err => {
        alert("An error has occurred during updating the note");
      }
    );
  }

  public selectAllNotes() {
    this.selectedNotebook = null;
    this.getAllNotes();
  }
}
