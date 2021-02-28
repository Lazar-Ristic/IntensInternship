import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  searchName: string = "";

  constructor(
    private _httpClient: HttpClient,
  ) {}

  ngOnInit(): void {
    this.getJobCandidates();
  }

  getJobCandidates() {

  }
}
