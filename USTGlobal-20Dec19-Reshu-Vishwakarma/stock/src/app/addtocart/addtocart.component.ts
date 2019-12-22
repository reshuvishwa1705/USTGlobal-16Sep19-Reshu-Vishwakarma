import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-addtocart',
  templateUrl: './addtocart.component.html',
  styleUrls: ['./addtocart.component.css']
})
export class AddtocartComponent implements OnInit {

  constructor(private auth: AuthService) { }
  error: string;
  value: string;
  msg: string;
  arr: any;
  i = 1;
  getAll(){
    this.error = null;
    this.auth.getAllProduct().subscribe(res => {
      console.log(res);
      this.value = res.beans;
      this.msg = res.description;
    }, err => {
      this.error = err.message;
    });
  }
  addToCart(prod) {
    localStorage.setItem('product'+ this.i, prod);
    this.msg = 'add product in cart';
    this.i++;
  }
  ngOnInit() {
  }

}
