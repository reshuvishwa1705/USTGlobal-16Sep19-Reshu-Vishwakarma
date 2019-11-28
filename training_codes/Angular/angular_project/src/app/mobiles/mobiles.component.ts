import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-mobiles',
  templateUrl: './mobiles.component.html',
  styleUrls: ['./mobiles.component.css']
})
export class MobilesComponent implements OnInit {

  selectedMobile;
  mobiles = [{
    name: 'Ikall',
    imgUrl:"https://cdn.pixabay.com/photo/2017/04/03/15/52/mobile-phone-2198770__340.png"
  }, {
    name: 'Karbonn',
    imgUrl:"https://cdn.pixabay.com/photo/2015/05/12/09/13/social-media-763731__340.jpg"
  }, {
    name: 'Redmi MI4A',
    imgUrl:"https://cdn.pixabay.com/photo/2016/11/29/12/30/android-1869510__340.jpg"
  }, {
    name: 'Iphone 8',
    imgUrl:"https://cdn.pixabay.com/photo/2018/05/01/13/04/sport-3365503__340.jpg"
  }
];

  constructor() { }

  ngOnInit() {
  }
  sendMobile(mobile){
    this.selectedMobile = mobile;
    console.log(mobile);
  }

}

