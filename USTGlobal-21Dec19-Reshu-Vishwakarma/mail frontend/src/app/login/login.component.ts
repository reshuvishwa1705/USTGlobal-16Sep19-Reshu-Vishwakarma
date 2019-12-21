import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private user: UserService, private router: Router) { }

  login(form: NgForm) {
    console.log(form);
    this.user.login(form.value).subscribe(response => {
      if (response !=  null ) {
        alert('Login Successful');
        console.log('Response of login', response);
        alert('Login Successful');
        this.router.navigateByUrl('/');
      }
      form.reset();
    }, err => {
      console.log(err);
    }, () => {
      console.log();
    });
  }

  ngOnInit() {
  }

}
