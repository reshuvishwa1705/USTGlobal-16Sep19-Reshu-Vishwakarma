import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {

  addProductForm = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z" "]+$'), Validators.maxLength(25)]),
    category: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z " "]+$')]),
    company: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z " "]+$')]),
    quantity: new FormControl('', [Validators.required, Validators.pattern('/^-?(0|[1-9]\d*)?$/')]),
    price: new FormControl('', [Validators.required, Validators.pattern('/^-?(0|[1-9]|[.]\d*)?$/')])
    });
    get name() {
      return this.addProductForm.get('name');
    }
    get category() {
      return this.addProductForm.get('category');
    }
    get company() {
      return this.addProductForm.get('company');
    }
    get quantity() {
      return this.addProductForm.get('quantity');
    }
    get price() {
      return this.addProductForm.get('price');
    }
    constructor(private auth: AuthService) { }
    error: string;
    value: any;
    msg: string;
    productAdd(prod) {
      this.error = null;
      this.auth.addProduct(prod.value).subscribe(res => {
        console.log(res);
        // this.msg = JSON.stringify(res.bean); 
      }, err => {
        this.error = err.message;
      });
    }
      ngOnInit() {
  }

}
