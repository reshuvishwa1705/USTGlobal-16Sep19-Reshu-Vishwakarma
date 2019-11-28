import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-laptops',
  templateUrl: './laptops.component.html',
  styleUrls: ['./laptops.component.css']
})
export class LaptopsComponent implements OnInit {
  selectedLaptop;
  laptops = [{
    name: 'Apple Macbook air',
    imgUrl:"https://cdn.pixabay.com/photo/2014/05/02/21/49/home-office-336373__340.jpg"
  }, {
    name: 'Acer',
    imgUrl:"https://cdn.pixabay.com/photo/2015/05/31/10/51/acer-791027__340.jpg"
  }, {
    name: 'Motorola',
    imgUrl:"https://cdn.pixabay.com/photo/2018/09/07/05/41/surface-book-3660000__340.jpg"
  }, {
    name: 'HP Pavillion',
    imgUrl:"https://cdn.pixabay.com/photo/2015/07/26/17/29/mixer-861431__340.jpg"
  },
];

  constructor() { }

  ngOnInit() {
  }
  sendLaptop(laptop){
    this.selectedLaptop = laptop;
    console.log(laptop);
  }
}
