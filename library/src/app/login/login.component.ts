import { Component, OnInit } from '@angular/core';
import { NgForm, FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { Session } from 'protractor';
import { CustomValidators } from '../custom-validators';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  error: string;
  msg: string;
  constructor(private auth: AuthService, private router: Router) { }
  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email ]),
    password: new FormControl('', [Validators.required])

  });
  get email() {
    return this.loginForm.get('email');
  }
  get password() {
    return this.loginForm.get('password');
  }
  login(form) {
    this.error = null;
    console.log(form.value);
    this.auth.loginUser(form.value).subscribe(data => {
      console.log('Response of Login', data);
      if (data && data.message === 'Login Succesfully') {
        sessionStorage.setItem('userDetails', JSON.stringify(data));
        this.router.navigateByUrl('/');
      } else {
        this.msg = JSON.stringify(data.message);
      }
      form.reset();
    }, err => {
      console.log(err);
      this.error = err.error.message;
    });
  }

  ngOnInit() {
  }

}
