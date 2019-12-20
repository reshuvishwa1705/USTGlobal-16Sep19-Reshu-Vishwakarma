import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HeaderComponent } from './header/header.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { StudentsearchComponent } from './studentsearch/studentsearch.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { ListOfBookComponent } from './list-of-book/list-of-book.component';
import { AddbookComponent } from './addbook/addbook.component';
import { LibrariansearchComponent } from './librariansearch/librariansearch.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HeaderComponent,
    HomeComponent,
    StudentsearchComponent,
    ListOfBookComponent,
    AddbookComponent,
    LibrariansearchComponent,
    ChangepasswordComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AngularFontAwesomeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
