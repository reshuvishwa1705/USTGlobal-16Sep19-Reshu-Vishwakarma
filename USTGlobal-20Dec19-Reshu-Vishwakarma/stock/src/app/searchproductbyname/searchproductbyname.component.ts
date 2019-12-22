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

  getProductByName(event) {
    this.error = null;
    this.value = event.target.value;
    this.auth.getName(this.value).subscribe(res => {
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
