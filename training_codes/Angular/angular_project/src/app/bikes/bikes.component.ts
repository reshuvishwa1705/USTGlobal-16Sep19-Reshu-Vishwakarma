import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bikes',
  templateUrl: './bikes.component.html',
  styleUrls: ['./bikes.component.css']
})
export class BikesComponent implements OnInit {
  selectedBike;
  bikes = [{
    name: 'BMW',
    imgUrl:"https://cdn.pixabay.com/photo/2016/04/07/06/53/bmw-1313343__340.jpg"
  }, {
    name: 'Kawasaki',
    imgUrl:"https://cdn.pixabay.com/photo/2015/09/08/21/02/superbike-930715__340.jpg"
  }, {
    name: 'RE Interceptor',
    imgUrl:"https://cdn.pixabay.com/photo/2014/12/16/03/37/motor-cycle-569865__340.jpg"
  }, {
    name: 'Gixer SF',
    imgUrl:"https://cdn.pixabay.com/photo/2017/07/01/03/47/bike-2460493__340.jpg"
  }
];
  constructor() { }

  ngOnInit() {
  }
  sendBike(bike) {
    this.selectedBike = bike;
    console.log(bike);
  }

}
