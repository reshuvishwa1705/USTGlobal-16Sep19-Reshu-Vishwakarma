import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgSwitch } from '@angular/common';

@Component({
  selector: 'app-countries',
  templateUrl: './countries.component.html',
  styleUrls: ['./countries.component.css']
})
export class CountriesComponent implements OnInit {
country;
con;

  constructor( private http: HttpClient) {
  }

  ngOnInit() {
  }
  getCountries(event: any){
    this.con = event.target.value;
    console.log(this.con);
    switch (this.con) {
      case 'us':
        this.http.get<any>('https://newsapi.org/v2/top-headlines?country=us&apiKey=1f6caac6e5f1481eb234130797a565a5').subscribe( data =>{
      this.country = data.article;
      
    }, err =>{
      console.log(err);
    }, () => {
      console.log("data got successfully");
    })
        break;
    case 'in':
        this.http.get<any>('https://newsapi.org/v2/top-headlines?country=in&apiKey=1f6caac6e5f1481eb234130797a565a5').subscribe( data =>{
          this.country = data.article;
        }, err =>{
          console.log(err);
        }, () => {
          console.log("data got successfully");
        })
        break;
        case 'de':
            this.http.get<any>('https://newsapi.org/v2/top-headlines?country=de&apiKey=1f6caac6e5f1481eb234130797a565a5').subscribe( data =>{
              this.country = data.article;
            }, err =>{
              console.log(err);
            }, () => {
              console.log("data got successfully");
            })
          break;
          case 'rs':
              this.http.get<any>('https://newsapi.org/v2/top-headlines?country=rs&apiKey=1f6caac6e5f1481eb234130797a565a5').subscribe( data =>{
                this.country = data.article;
              }, err =>{
                console.log(err);
              }, () => {
                console.log("data got successfully");
              })
              break;
      default:
        break;
    }
    
  }

}
