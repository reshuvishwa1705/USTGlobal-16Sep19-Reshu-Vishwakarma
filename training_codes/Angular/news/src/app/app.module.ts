import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { CountriesComponent } from './countries/countries.component';
import { CategoriesComponent } from './categories/categories.component';
import { SourcesComponent } from './sources/sources.component';
import { SearchNewsComponent } from './search-news/search-news.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { ChildCountriesComponent } from './child-countries/child-countries.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CountriesComponent,
    CategoriesComponent,
    SourcesComponent,
    SearchNewsComponent,
    ChildCountriesComponent,
   
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    // AppRoutingModule
    RouterModule.forRoot([
      {path: 'countries', component: CountriesComponent},
      {path: 'categories', component: CategoriesComponent},
      {path: 'sources', component: SourcesComponent},
{path: 'searchNews', component: SearchNewsComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
