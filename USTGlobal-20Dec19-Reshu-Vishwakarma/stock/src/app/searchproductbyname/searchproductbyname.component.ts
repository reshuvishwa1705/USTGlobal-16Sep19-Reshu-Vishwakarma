import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-searchproductbyname',
  templateUrl: './searchproductbyname.component.html',
  styleUrls: ['./searchproductbyname.component.css']
})
export class SearchproductbynameComponent implements OnInit {

  constructor(private auth: AuthService) { }
  error: string;
  value: any;
  msg: string;
  i = 1;
  getProductByName(event) {
    this.error = null;
    this.value = event.target.value;
    this.auth.getName(this.value).subscribe(res => {
      console.log(res);
      // this.value = res.bean;
    }, err => {
      this.error = err.message;
    });
  }
  addToCart(prod){
    localStorage.setItem("product"+this.i , prod);
    this.i++;
  }
  ngOnInit() {
  }

}
