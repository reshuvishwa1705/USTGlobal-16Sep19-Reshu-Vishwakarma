import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router) { }
  isLoggedIn() {
    const userDetails = JSON.parse(sessionStorage.getItem('userDetails'));
    if (userDetails) {
      return true;
    }
    else {
      return false;
    }
  }

  isLibrarian() {
    const userDetails = JSON.parse(sessionStorage.getItem('userDetails'));
    if (userDetails && userDetails.userBean.role === 'librarian') {
      return true;
    }
    else {
      return false;
    }
  }
  isStudent() {
    const userDetails = JSON.parse(sessionStorage.getItem('userDetails'));
    if (userDetails && userDetails.userBean.role === 'student') {
      return true;
    }
    else {
      return false;
    }
  }

  logout() {
    sessionStorage.removeItem('userDetails');
    return this.router.navigateByUrl('/login');
  }

  ngOnInit() {
  }

}
