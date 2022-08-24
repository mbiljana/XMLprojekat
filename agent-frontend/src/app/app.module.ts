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
import { CompanyProfileComponent } from './company-profile/company-profile.component';

import { PostListComponent } from './post-list/post-list.component';
import { PostItemComponent } from './post-item/post-item.component';
import { PostProfileComponent } from './post-profile/post-profile.component';

import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { UpdateCompanyComponent } from './update-company/update-company.component';
import { SearchCompanyComponent } from './search-company/search-company.component';
import { CompanySearchProfileComponent } from './company-search-profile/company-search-profile.component';
import { NewCompanyCommentComponent } from './new-company-comment/new-company-comment.component';
import { CommentListComponent } from './comment-list/comment-list.component';
import { CommentItemComponent } from './comment-item/comment-item.component';


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
    OneRequestComponent,
    CompanyProfileComponent,

    UpdateProfileComponent,
    UpdateCompanyComponent,


    PostListComponent,
    PostItemComponent,
    PostProfileComponent,
    UpdateProfileComponent,
    SearchCompanyComponent,
    CompanySearchProfileComponent,
    NewCompanyCommentComponent,
    CommentListComponent,
    CommentItemComponent


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
