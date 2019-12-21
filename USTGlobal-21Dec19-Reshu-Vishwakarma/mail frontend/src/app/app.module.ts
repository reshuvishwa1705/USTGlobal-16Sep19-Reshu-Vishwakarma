import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { HttpClientModule } from '@angular/common/http';
import { ComposeMailComponent } from './compose-mail/compose-mail.component';
import { DeletedMailComponent } from './deleted-mail/deleted-mail.component';
import { SentmailComponent } from './sentmail/sentmail.component';
import { HomeComponent } from './home/home.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { InboxComponent } from './inbox/inbox.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { DraftComponent } from './draft/draft.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ComposeMailComponent,
    DeletedMailComponent,
    SentmailComponent,
    HomeComponent,
    DraftComponent,
    ChangepasswordComponent,
    InboxComponent,
    RegisterComponent,
    LoginComponent


  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: 'home', component: HomeComponent },
      { path: 'compose', component: ComposeMailComponent },
      { path: 'sent-mail', component: SentmailComponent },
      { path: 'change', component: ChangepasswordComponent },
      { path: 'inbox', component: InboxComponent },
      { path: 'register', component: RegisterComponent },
      { path: 'login', component: LoginComponent },
      {path: 'draft', component: DraftComponent}

    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
