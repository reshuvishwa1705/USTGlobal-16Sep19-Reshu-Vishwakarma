import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) { }
  registerUser(user): Observable<any> {
    return this.http.post('http://localhost:8080/libraryapp/register', user);
  }
  loginUser(user): Observable<any> {
    return this.http.post('http://localhost:8080/libraryapp/login', user);
  }
  getBook(author): Observable<any> {
    return this.http.get('http://localhost:8080/libraryapp/search/' + author);
  }
  issueBook(bookId, studentId): Observable<any> {
    return this.http.get('http://localhost:8080/libraryapp/issuebook?bid=' + bookId + '&uid=' + studentId);
  }
  returnBook(bookId, studentId): Observable<any> {
    return this.http.get('http://localhost:8080/libraryapp/returnbook?bid=' + bookId + '&uid=' + studentId);
  }
  listOfBook(): Observable<any> {
    return this.http.get('http://localhost:8080/libraryapp/getallbook');
  }
  deleteBook(bid): Observable<any> {
    return this.http.delete(`http://localhost:8080/libraryapp/delete/${bid}`);
  }
  addBook(book): Observable<any> {
    return this.http.post('http://localhost:8080/libraryapp/addbook', book);
  }
  searchBook(bid): Observable<any> {
    return this.http.get('http://localhost:8080/libraryapp/searchbook?bid=' + bid);
  }
  updateBook(book): Observable<any> {
    return this.http.put('http://localhost:8080/libraryapp/updatebook', book);
  }
  changePassword(email,pwd): Observable<any> {
    return this.http.post('http://localhost:8080/libraryapp/changepassword', {email:email,password:pwd});
  }
}
