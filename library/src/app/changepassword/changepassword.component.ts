import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { Validators, FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-changepassword',
  templateUrl: './changepassword.component.html',
  styleUrls: ['./changepassword.component.css']
})
export class ChangepasswordComponent implements OnInit {

  error: string;
  msg: string;
  constructor(private auth: AuthService, private router: Router) { }
  changepassword = new FormGroup({
    confirmpassword: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required,Validators.pattern('(?=\\D*\\d)(?=[^a-z]*[a-z])(?=[^A-Z]*[A-Z]).{8,30}')])
  });
  get confirmpassword() {
    return this.changepassword.get('confirmpassword');
  }
  get password() {
    return this.changepassword.get('password');
  }
  change(form) {
    this.error = null;
    console.log(form.value);
    const pwd = form.value.password;
    const cnfpwd = form.value.confirmpassword;
    if (pwd === cnfpwd) {
    const userDetail = JSON.parse(sessionStorage.getItem('userDetails'));
    const email = userDetail.userBean.email;
    this.auth.changePassword(email, pwd).subscribe(res => {
      console.log('Response of ChangePassword', res);
      this.msg = JSON.stringify(res.description);

      form.reset();
    }, err => {
      console.log(err);
      this.error = err.error.message;
    });
  } else {
    this.msg = 'password not matched';
  }
  }
  ngOnInit() {

  }

}
