import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-property-binding',
  templateUrl: './property-binding.component.html',
  styleUrls: ['./property-binding.component.css']
})
export class PropertyBindingComponent implements OnInit {

  name: string = 'Marie';
imgUrl: string = 'https://cdn.pixabay.com/photo/2019/06/02/17/27/summer-4246927_960_720.jpg';
address: string = 'Narmada campus near jk road';
clrName: string= 'red';
isActive: boolean= false;
colSpanValue: number= 2;

  constructor() {
    setInterval(() => {
      this.clrName= 'blue';
this.isActive = !this.isActive;
    }, 2000);
   }

  ngOnInit() {
    setInterval(() => {
this.clrName= 'yellow';
    }, 2000);
  }

}
