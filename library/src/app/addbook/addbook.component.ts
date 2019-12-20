import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addbook',
  templateUrl: './addbook.component.html',
  styleUrls: ['./addbook.component.css']
})
export class AddbookComponent implements OnInit {
  error: string;
  msg: string;

  constructor(private auth: AuthService, private router: Router) { }
  addBookForm = new FormGroup({
    bid: new FormControl('', [Validators.required, Validators.pattern('/^-?(0|[1-9]\d*)?$/')]),
    bname: new FormControl('', [Validators.required, Validators.maxLength(20)]),
    bauthor: new FormControl('', [Validators.required]),
    bcopies: new FormControl('', [Validators.required,  Validators.pattern('/^-?(0|[1-9]\d*)?$/')])
  });
  get bid() {
    return this.addBookForm.get('bid');
  }
  get bname() {
    return this.addBookForm.get('bname');
  }
  get bauthor() {
    return this.addBookForm.get('bauthor');
  }
  get bcopies() {
    return this.addBookForm.get('bcopies');
  }
  add(form) {
    this.error = null;
    this.auth.addBook(form.value).subscribe(res => {
      this.msg = JSON.stringify(res.description);
      console.log(res);
      form.reset();
    }, err => {
      console.log(err);
      this.error = err.message;
    });
  }
  ngOnInit() {
  }

}
