import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {

  selectedMovie;
  movies = [{
    name: 'Captain America',
    imgUrl:"https://cdn.pixabay.com/photo/2019/08/25/06/43/captain-america-4428842__340.jpg"
  }, {
    name: 'Avengers',
    imgUrl:"https://cdn.pixabay.com/photo/2018/05/08/11/36/avenger-3382834__340.jpg"
  }, {
    name: 'Ironman',
    imgUrl:"https://cdn.pixabay.com/photo/2019/05/25/12/30/iron-man-4228269__340.jpg"
  }, {
    name: 'Life of pi',
    imgUrl:"https://image.shutterstock.com/image-photo/natural-quartz-sandstone-pillar-avatar-260nw-1148627891.jpg"
  }
];

  constructor() { }

  ngOnInit() {
  }
  sendMovie(movie){
    this.selectedMovie = movie;
    console.log(movie);
  }

}
