import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {
movies;
  constructor(private http: HttpClient) {
    
   }

  ngOnInit() {
  }
  getMovies() {
    this.http.get<any>('http://www.omdbapi.com/?i=tt3896198&apikey=8911abe4').subscribe(data =>{
       this.movies = data.search;
    }, err => {
        console.log(err);
    }, () => {
        console.log('Movies got successfully');
    })
}
}
