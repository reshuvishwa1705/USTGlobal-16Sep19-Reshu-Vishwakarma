import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})


export class UserService {
mailBean: any[];
isLoggedIn = false;

  constructor(private http: HttpClient) { }

  registerUser(user): Observable<any> {
    return this.http.post('http://localhost:8081/register', user);
  }
  login(user): Observable<any> {
    return this.http.post('http://localhost:8081/login', user);
  }
  changePassword(user): Observable<any> {
    return this.http.put('http://localhost:8081/changePassword', user);
  }
inbox() {
  return this.http.get<any>('');
}
delete(mailBean) {
  return this.http.delete<any>('');
}
isAdminLoggedIn() {
  if (this.isLoggedIn) {
    return true;
  }
  return false;
}

}
