import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { AddproductComponent } from './addproduct/addproduct.component';
import { UpdateproductComponent } from './updateproduct/updateproduct.component';
import { SearchproductbynameComponent } from './searchproductbyname/searchproductbyname.component';
import { SearchproductbycategoryComponent } from './searchproductbycategory/searchproductbycategory.component';
import { SearchproductbycompanyComponent } from './searchproductbycompany/searchproductbycompany.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AddproductComponent,
    UpdateproductComponent,
    SearchproductbynameComponent,
    SearchproductbycategoryComponent,
    SearchproductbycompanyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
