import { MatIconModule } from '@angular/material/icon';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { MatDialogModule } from '@angular/material/dialog';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SearchProfileComponent } from './search-profile/search-profile.component';
import { MainPageComponent } from './main-page/main-page.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FoundUsersComponent } from './found-users/found-users.component';
import { FoundUserComponent } from './found-user/found-user.component';
import { CompanyProfileComponent } from './company-profile/company-profile.component';
import { FoundCompanyComponent } from './found-company/found-company.component';
import { SearchComponent } from './search/search.component';
import { PostListComponent } from './post-list/post-list.component';
import { PostItemComponent } from './post-item/post-item.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { SignInPageComponent } from './sign-in-page/sign-in-page.component';
import { SendRequestsComponent } from './send-requests/send-requests.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UserPersonalProfileComponent } from './user-personal-profile/user-personal-profile.component';
import { MakeNewUserPostComponent } from './make-new-user-post/make-new-user-post.component';
import { UserPostListComponent } from './user-post-list/user-post-list.component';
import { UserPostComponent } from './user-post/user-post.component';
import { UserPostProfileComponent } from './user-post-profile/user-post-profile.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { AddCommentComponent } from './add-comment/add-comment.component';
import { NavbarProfileComponent } from './navbar-profile/navbar-profile.component';
import { MessagesComponent } from './messages/messages.component';
import { UserMessagesComponent } from './user-messages/user-messages.component';
import { SendMessageComponent } from './send-message/send-message.component';
import { CompanyPostProfileComponent } from './company-post-profile/company-post-profile.component';
import { PopUpLoginComponent } from './pop-up-login/pop-up-login.component';


@NgModule({
  declarations: [
    AppComponent,
    SearchProfileComponent,
    MainPageComponent,
    NavbarComponent,
    FoundUsersComponent,
    FoundUserComponent,
    CompanyProfileComponent,
    FoundCompanyComponent,
    SearchComponent,
    PostListComponent,
    PostItemComponent,
    RegisterPageComponent,
    SignInPageComponent,
    SendRequestsComponent,

    UserProfileComponent,
    UserPersonalProfileComponent,
    MakeNewUserPostComponent,
    UserPostListComponent,
    UserPostComponent,
    UserPostProfileComponent,
    AddCommentComponent,
    NavbarProfileComponent,
    MessagesComponent,
    UserMessagesComponent,

    SendMessageComponent,

    CompanyPostProfileComponent,
     PopUpLoginComponent


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatIconModule,
    BrowserAnimationsModule,
    CommonModule,ReactiveFormsModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
