import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddproductComponent } from './addproduct/addproduct.component';
import { SearchproductbynameComponent } from './searchproductbyname/searchproductbyname.component';
import { SearchproductbycategoryComponent } from './searchproductbycategory/searchproductbycategory.component';
import { SearchproductbycompanyComponent } from './searchproductbycompany/searchproductbycompany.component';
import { UpdateproductComponent } from './updateproduct/updateproduct.component';
import { AddtocartComponent } from './addtocart/addtocart.component';


const routes: Routes = [
  {path: 'addproduct', component: AddproductComponent},
  {path: 'name', component: SearchproductbynameComponent},
  {path: 'category', component: SearchproductbycategoryComponent},
  {path: 'company', component: SearchproductbycompanyComponent},
  {path: 'update', component: UpdateproductComponent},
  {path: 'cart', component: AddtocartComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
