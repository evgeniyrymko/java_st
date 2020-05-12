import {Component, OnInit} from '@angular/core';
import {Notebook} from "./model/notebook";
import {ApiService} from "../shared/api.service";

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent implements OnInit {
  notebooks: Notebook[] = [];

  constructor(private apiService: ApiService) {
  }

  ngOnInit(): void {
    this.getAllNotebooks();
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
      res=>{},
      err=>{
        alert("An error has occurred during updating (changing) the notebook");
      }
    );
  }

  public deleteNotebook(notebook: Notebook) {
    if (confirm("Are you sure you want to delete the notebook?")){
      this.apiService.deleteNotebook(notebook.id).subscribe(
        res =>{
          let indexOfNotebook = this.notebooks.indexOf(notebook);
          this.notebooks.splice(indexOfNotebook,1);
        },
        err =>{
          alert("An error has occurred during deleting the notebook");
        }
      );
    }
  }
}
