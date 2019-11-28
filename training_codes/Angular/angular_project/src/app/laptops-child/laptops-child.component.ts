import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-laptops-child',
  templateUrl: './laptops-child.component.html',
  styleUrls: ['./laptops-child.component.css']
})
export class LaptopsChildComponent implements OnInit {
  laptopName;
  @Input() laptop: {image: string, name: string};
  constructor() { }

  ngOnInit() {
  }

}
