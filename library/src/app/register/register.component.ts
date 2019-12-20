import { Component, OnInit, OnDestroy } from '@angular/core';
import { NgForm, FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit, OnDestroy {
  error: string;
  msg: string;

  constructor(private auth: AuthService, private router: Router) { }
  registerForm = new FormGroup({
    uname: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z]+$'), Validators.maxLength(25)]),
    email: new FormControl('', [Validators.required, Validators.email]),
    // tslint:disable-next-line: max-line-length
    password: new FormControl('', [Validators.required, Validators.pattern('(?=\\D*\\d)(?=[^a-z]*[a-z])(?=[^A-Z]*[A-Z]).{8,30}'), Validators.maxLength(15), Validators.minLength(8)])
  });
  get uname() {
    return this.registerForm.get('uname');
  }
  get email() {
    return this.registerForm.get('email');
  }
  get password() {
    return this.registerForm.get('password');
  }
  register(form) {
    this.error = null;
    this.auth.registerUser(form.value).subscribe(res => {
      this.msg = JSON.stringify(res.message);
      console.log(res);
      if (res && res.message === 'Registration Success') {
        this.router.navigateByUrl('/login');
      }
      form.reset();
    }, err => {
      console.log(err);
      this.error = err.message;
    });
  }
  ngOnInit() {
  }
  ngOnDestroy() {
    this.error = null;
  }
}
