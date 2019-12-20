import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-librariansearch',
  templateUrl: './librariansearch.component.html',
  styleUrls: ['./librariansearch.component.css']
})
export class LibrariansearchComponent implements OnInit {

  constructor(private auth: AuthService) { }
  error: string;
  id: number;
  msg: string;
  // tslint:disable-next-line: ban-types
  userId: Number;
  value: string;
  books: any;
  booksearch(event) {
    this.error = null;
    this.id = event.target.value;
    this.auth.searchBook(this.id).subscribe(res => {
      console.log(res);
      this.books = res.bookBeans;
    }, err => {
      this.error = err.message;
    });
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
  ngOnInit() {
  }

}
