import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ComposeMailComponent } from './compose-mail/compose-mail.component';
import { DeletedMailComponent } from './deleted-mail/deleted-mail.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
