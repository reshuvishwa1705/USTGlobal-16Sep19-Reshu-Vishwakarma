import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-bikes-child',
  templateUrl: './bikes-child.component.html',
  styleUrls: ['./bikes-child.component.css']
})
export class BikesChildComponent implements OnInit {
bikeName;
@Input() bike: {imgUrl: string, name: string};
  constructor() { }

  ngOnInit() {
  }

}
