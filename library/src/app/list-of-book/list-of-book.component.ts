import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-list-of-book',
  templateUrl: './list-of-book.component.html',
  styleUrls: ['./list-of-book.component.css']
})
export class ListOfBookComponent implements OnInit {
  error: string;
  msg: string;
  value: any;
  selectedUser: any;
  constructor(private auth: AuthService) {
    this.bookList();
  }
  bookList() {
    this.error = null;
    this.auth.listOfBook().subscribe(res => {
      console.log(res);
      this.value = res.bookBeans;
      if (res.statusCode === 401) {
        this.msg = JSON.stringify(res.description);
      }
    }, err => {
      this.error = err.message;
    });
  }
  delete(book) {
    this.auth.deleteBook(book.bid).subscribe(res => {
      console.log(res);
      this.msg = JSON.stringify(res.description);
      this.bookList();
    }, err => {
      this.error = err.message;
    });
  }
  selectUser(user) {
    console.log(user);
    this.selectedUser = user;
  }
  updateData(form) {
    console.log(form.value);
    this.auth.updateBook(form.value).subscribe(data => {
      console.log(data);
      this.bookList();
    }, err => {
      console.log(err);
    }, () => {
      console.log('data updated successfully');
    });
  }
  ngOnInit() {
  }

}
