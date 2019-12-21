import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-changepassword',
  templateUrl: './changepassword.component.html',
  styleUrls: ['./changepassword.component.css']
})
export class ChangepasswordComponent implements OnInit {

  constructor(private user: UserService, private router: Router) { }

  change(form : NgForm){
    this.user.changePassword(form.value).subscribe(res => {
      console.log(res);
      if (res !== 0) {
        alert('Successfully Cahnged Please go for HomePage');
        this.router.navigateByUrl('/');
      } else {
        alert('Change Password failed');
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
