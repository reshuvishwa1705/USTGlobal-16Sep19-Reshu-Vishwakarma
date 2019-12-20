import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-studentsearch',
  templateUrl: './studentsearch.component.html',
  styleUrls: ['./studentsearch.component.css']
})
export class StudentsearchComponent implements OnInit {

  constructor(private auth: AuthService) { }
  error: string;
  value: string;
  msg: string;
  userId: Number;
  getbook(event) {
    this.error = null;
    this.value = event.target.value;
    this.auth.getBook(this.value).subscribe(res => {
      console.log(res);
      this.value = res.bookBeans;
    }, err => {
      this.error = err.message;
    });
  }
  issue(book){
    let userDetail = JSON.parse(sessionStorage.getItem('userDetails'));
    this.userId = userDetail.userBean.uid;
    this.auth.issueBook(book.bid, this.userId).subscribe(res => {
      console.log(res);
      this.msg = JSON.stringify(res.description);
    }, err => {
      this.error = err.message;
    });
  }
  return(book){
    let userDetail = JSON.parse(sessionStorage.getItem('userDetails'));
    this.userId = userDetail.userBean.uid;
    this.auth.returnBook(book.bid, this.userId).subscribe(res => {
      console.log(res);
      this.msg = JSON.stringify(res.description);
    }, err => {
      this.error = err.message;
    });
  }
  ngOnInit() {
  }

}
