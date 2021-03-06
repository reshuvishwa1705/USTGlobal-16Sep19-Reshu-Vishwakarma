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
  getProductByCategory(event) {
    this.error = null;
    this.value = event.target.value;
    this.auth.getCategory(this.value).subscribe(res => {
      console.log(res);
      this.value = res.beans;
      this.msg = res.description;
    }, err => {
      this.error = err.message;
    });
  }
 
  ngOnInit() {
  }

}
