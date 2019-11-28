import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { CarsComponent } from './cars/cars.component';
import { BikesComponent } from './bikes/bikes.component';
import { MoviesComponent } from './movies/movies.component';
import { LaptopsComponent } from './laptops/laptops.component';
import { MobilesComponent } from './mobiles/mobiles.component';
import { RouterModule } from '@angular/router';
import { CarChildComponent } from './car-child/car-child.component';
import { LaptopsChildComponent } from './laptops-child/laptops-child.component';
import { BikesChildComponent } from './bikes-child/bikes-child.component';
import { MoviesChildComponent } from './movies-child/movies-child.component';
import { MobilesChildComponent } from './mobiles-child/mobiles-child.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    CarsComponent,
    BikesComponent,
    MoviesComponent,
    LaptopsComponent,
    MobilesComponent,
    CarChildComponent,
    LaptopsChildComponent,
    BikesChildComponent,
    MoviesChildComponent,
    MobilesChildComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot([
      {path : 'home', component: HomeComponent},
      {path : 'cars', component: CarsComponent},
      {path: 'bikes', component: BikesComponent},
      {path: 'movies', component: MoviesComponent},
      {path: 'laptops', component: LaptopsComponent},
      {path: 'mobiles', component: MobilesComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
