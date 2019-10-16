import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-addmovie',
  templateUrl: './addmovie.component.html',
  styleUrls: ['./addmovie.component.css']
})
export class AddmovieComponent implements OnInit {
get addmovie(){
  return this.form.get('addmovie');
}
 get movietitle(){
   return this.form.get('movietitle');
 }
 get movieimg(){
   return this.form.get('movieimg');
 }
 get moviedesc(){
   return this.form.get('moviedesc');
 }
form = new FormGroup({
  addmovie: new FormControl('',[Validators.required]),
  movietitle: new FormControl('',[Validators.required]),
  movieimg: new FormControl('',[Validators.required]),
  moviedesc: new FormControl('', [Validators.required])
});
constructor() { }
  ngOnInit() {
  }
  addData(form){
    console.log(form.value);
  }
}
