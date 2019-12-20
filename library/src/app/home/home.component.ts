import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  name: string;
  constructor() { }

  ngOnInit() {
    let userDetails = JSON.parse(sessionStorage.getItem('userDetails'));
    this.name = userDetails.userBean.uname;
  }

}
