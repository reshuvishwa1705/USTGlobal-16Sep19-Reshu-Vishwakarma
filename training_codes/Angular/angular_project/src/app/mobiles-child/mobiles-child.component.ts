import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-mobiles-child',
  templateUrl: './mobiles-child.component.html',
  styleUrls: ['./mobiles-child.component.css']
})
export class MobilesChildComponent implements OnInit {
  @Input() mobile: {image: string, name: string};
  constructor() { }

  ngOnInit() {
  }

}
