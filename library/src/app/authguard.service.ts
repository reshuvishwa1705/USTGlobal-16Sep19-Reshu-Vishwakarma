import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthguardService implements CanActivate{
  canActivate(route : ActivatedRouteSnapshot): boolean{
    const expectedRoleArray  = route.data.roles;
    const userDetails = JSON.parse(sessionStorage.getItem('userDetails'));
    let expectedRole : string;
    for(const index in expectedRoleArray){
      if(userDetails && userDetails.userBean.role === expectedRoleArray[index]){
        expectedRole = expectedRoleArray[index];
      }
    }
    if (userDetails && expectedRole === userDetails.userBean.role){
      console.log("User Authenticated");
      return true;
    }
    else {
      console.log("User not Authenticated");
      return false;
    }
      }
  constructor() { }
}
