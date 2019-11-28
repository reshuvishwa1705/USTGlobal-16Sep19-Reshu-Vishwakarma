import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ng-for',
  templateUrl: './ng-for.component.html',
  styleUrls: ['./ng-for.component.css']
})
export class NgForComponent implements OnInit {

  constructor() { }
  products = [{
    name:"EyeLiner",
    img: "https://image.shutterstock.com/image-photo/top-view-different-cosmetics-products-600w-388900513.jpg",
    price: 500
  }, {
    name: "Nature",
    img:"https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072823_960_720.jpg",
    price: 1000}
  ] ;
  ngOnInit() {
  }

}
