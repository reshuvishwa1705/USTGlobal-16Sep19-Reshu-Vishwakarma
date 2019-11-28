import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-child-countries',
  templateUrl: './child-countries.component.html',
  styleUrls: ['./child-countries.component.css']
})
export class ChildCountriesComponent implements OnInit {
@Input() getConData;
  constructor() { }

  ngOnInit() {
  }

}
