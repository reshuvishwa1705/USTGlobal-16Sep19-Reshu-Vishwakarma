import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private user: UserService, private router: Router) { }

  register(form: NgForm) {
    console.log('values are', form.value);
    this.user.registerUser(form.value).subscribe(res => {
      console.log(res);
      if (res !== 0) {
        alert('Successfully Registered Please go for login');
        this.router.navigateByUrl('/login');
      } else {
        alert('Registration failed');
      }
    }, err => {
      console.log(err);
    }, () => {
      console.log('data posted successfully');
    });

  }

  ngOnInit() {
  }

}
