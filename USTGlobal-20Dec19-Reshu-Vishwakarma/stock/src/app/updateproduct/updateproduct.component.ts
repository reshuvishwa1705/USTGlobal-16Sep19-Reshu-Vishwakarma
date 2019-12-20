import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-updateproduct',
  templateUrl: './updateproduct.component.html',
  styleUrls: ['./updateproduct.component.css']
})
export class UpdateproductComponent implements OnInit {

  constructor(private auth: AuthService) { }
  error: string;
  value: any;
  msg: string;
  updateProductForm = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z" "]+$'), Validators.maxLength(25)]),
    category: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z " "]+$')]),
    company: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z " "]+$')]),
    quantity: new FormControl('', [Validators.required, Validators.pattern('/^-?(0|[1-9]\d*)?$/')]),
    price: new FormControl('', [Validators.required, Validators.pattern('/^-?(0|[1-9]|[.]\d*)?$/')])
    });
    get name() {
      return this.updateProductForm.get('name');
    }
    get category() {
      return this.updateProductForm.get('category');
    }
    get company() {
      return this.updateProductForm.get('company');
    }
    get quantity() {
      return this.updateProductForm.get('quantity');
    }
    get price() {
      return this.updateProductForm.get('price');
    }
  updateData(form) {
    console.log(form.value);
    this.auth.updateProduct(form.value).subscribe(data => {
      console.log(data);   
    }, err => {
      console.log(err);
    }, () => {
      console.log('data updated successfully');
    });
  }
    ngOnInit() {
    }

}
