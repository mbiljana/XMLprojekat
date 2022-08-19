import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { MatIconModule } from '@angular/material/icon';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainPageComponent } from './main-page/main-page.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarProfileComponent } from './navbar-profile/navbar-profile.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { SignInPageComponent } from './sign-in-page/sign-in-page.component';
import { MakeNewPostComponent } from './make-new-post/make-new-post.component';
import { PersonalUserProfileComponent } from './personal-user-profile/personal-user-profile.component';
import { NewCompanyRequestComponent } from './new-company-request/new-company-request.component';
import { CompanyRequestListComponent } from './company-request-list/company-request-list.component';
import { CompanyRequestItemComponent } from './company-request-item/company-request-item.component';
import { OneRequestComponent } from './one-request/one-request.component';

@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    NavbarComponent,
    NavbarProfileComponent,
    RegisterPageComponent,
    SignInPageComponent,
    MakeNewPostComponent,
    PersonalUserProfileComponent,
    NewCompanyRequestComponent,
    CompanyRequestListComponent,
    CompanyRequestItemComponent,
    OneRequestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatIconModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
