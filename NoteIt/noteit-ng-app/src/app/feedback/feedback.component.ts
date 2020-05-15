import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {ApiService} from "../shared/api.service";

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {

  model: FeedbackViewModel = {
    name: '',
    email: '',
    feedback: ''
  };

  constructor(private apiService: ApiService) {
  }

  ngOnInit(): void {
  }

  sendFeedback(): void {
    this.apiService.postFeedback(this.model).subscribe(
      res => {
        location.reload();
      },
      err => {
        alert("An error occurred while sending a feedback");
      }
    );
  }

}

export interface FeedbackViewModel {
  name: string;
  email: string;
  feedback: string;
}