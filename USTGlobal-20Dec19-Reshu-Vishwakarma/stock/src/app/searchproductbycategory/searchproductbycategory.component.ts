import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-searchproductbycategory',
  templateUrl: './searchproductbycategory.component.html',
  styleUrls: ['./searchproductbycategory.component.css']
})
export class SearchproductbycategoryComponent implements OnInit {
  constructor(private auth: AuthService) { }
  error: string;
  value: string;
  msg: string;
  i = 1;
  getProductByCategory(event) {
    this.error = null;
    this.value = event.target.value;
    this.auth.getCategory(this.value).subscribe(res => {
      console.log(res);
      // this.value = res.beans;
    }, err => {
      this.error = err.message;
    });
  }
  addToCart(prod) {
    localStorage.setItem("product" + this.i, prod);
    this.i++;
  }
  ngOnInit() {
  }

}
