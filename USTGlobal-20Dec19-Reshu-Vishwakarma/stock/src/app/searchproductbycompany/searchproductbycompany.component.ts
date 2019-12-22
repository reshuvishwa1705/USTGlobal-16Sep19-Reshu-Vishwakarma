import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-searchproductbycompany',
  templateUrl: './searchproductbycompany.component.html',
  styleUrls: ['./searchproductbycompany.component.css']
})
export class SearchproductbycompanyComponent implements OnInit {
  constructor(private auth: AuthService) { }
  error: string;
  value: string;
  msg: string;
  getProductByCompany(event) {
    this.error = null;
    this.value = event.target.value;
    this.auth.getCompany(this.value).subscribe(res => {
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
