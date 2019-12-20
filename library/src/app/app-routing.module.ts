import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AuthService } from './auth.service';
import { AuthguardService } from './authguard.service';
import { StudentsearchComponent } from './studentsearch/studentsearch.component';
import { ListOfBookComponent } from './list-of-book/list-of-book.component';
import { AddbookComponent } from './addbook/addbook.component';
import { LibrariansearchComponent } from './librariansearch/librariansearch.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';


const routes: Routes = [
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  {
    path: '', component: HomeComponent,
    canActivate: [AuthguardService], data: { roles: ['student', 'librarian'] }
  },
  {
    path: 'studentsearch', component: StudentsearchComponent,
    canActivate: [AuthguardService], data: { roles: ['student'] }
  },
  {
    path: 'changepassword', component: ChangepasswordComponent,
    canActivate: [AuthguardService], data: { roles: ['student'] }
  },
  {
    path: 'booklist', component: ListOfBookComponent,
    canActivate: [AuthguardService], data: { roles: ['librarian'] }
  },
  {
    path: 'librariansearch', component: LibrariansearchComponent,
    canActivate: [AuthguardService], data: { roles: ['librarian'] }
  },
  {
    path: 'addbook', component: AddbookComponent,
    canActivate: [AuthguardService], data: { roles: ['librarian'] }
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
