import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit {
  selectedCar;
  cars = [{
    name: 'Sport Car',
    imgUrl:"https://cdn.pixabay.com/photo/2012/05/29/00/43/car-49278_960_720.jpg"
  }, {
    name: 'Benz Mercedes',
    imgUrl:"https://cdn.pixabay.com/photo/2016/12/03/18/57/amg-1880381_960_720.jpg"
  }, {
    name: 'BMW',
    imgUrl:"https://cdn.pixabay.com/photo/2013/07/13/11/48/bmw-158703_960_720.png"
  }, {
    name: 'Lamborghini',
    imgUrl:"https://cdn.pixabay.com/photo/2018/05/10/18/39/lamborghini-3388285_960_720.png"
  },
];

  constructor() { }

  ngOnInit() {
  }
  sendCar(car){
    this.selectedCar=car;
    console.log(car);
  }

}
