import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }
  addProduct(prod) {
    return this.http.post('http://localhost:8081/addproduct', prod);
  }
  getCategory(cate) {
    return this.http.get('http://localhost:8081/bycategory?category=' + cate);
  }
  getCompany(comp) {
    return this.http.get('http://localhost:8081/bycompany?company=' + comp);
  }
  getName(name): Observable<any> {
    return this.http.get('http://localhost:8081/byname?name=' + name);
  }
  updateProduct(prod) {
    return this.http.put('http://localhost:8081/modifyproduct', prod);
  }
  generateBill(list) {
    return this.http.post('http://localhost:8081/generate', list);
  }
  getAllProduct() {
    return this.http.get('http://localhost:8081/getall');
  }
}
