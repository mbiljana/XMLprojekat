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

import {UserPersonalProfileUpdateComponent} from "./user-personal-profile-update/user-personal-profile-update.component";

import { SendMessageComponent } from './send-message/send-message.component';
import { CompanyPostProfileComponent } from './company-post-profile/company-post-profile.component';
import { FollowRequestsComponent } from './follow-requests/follow-requests.component';
import { FollowRequestComponent } from './follow-request/follow-request.component';
import { PopUpLikeDislikeComponent } from './pop-up-like-dislike/pop-up-like-dislike.component';
import { PopUpLikedComponent } from './pop-up-liked/pop-up-liked.component';
import { ChatComponent } from './chat/chat.component';

import { AllPostFromFollowingComponent } from './all-post-from-following/all-post-from-following.component';
import {MatCardModule} from '@angular/material/card';
import { MatTabsModule } from '@angular/material/tabs';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { ViewConnectionsComponent } from './view-connections/view-connections.component';
import { ViewConnectionComponent } from './view-connection/view-connection.component';
import { ViewChatComponent } from './view-chat/view-chat.component';
import { ViewChatOnelineComponent } from './view-chat-oneline/view-chat-oneline.component';
import { ReplyMessageComponent } from './reply-message/reply-message.component';




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
    UserPersonalProfileUpdateComponent,
    AddCommentComponent,
    NavbarProfileComponent,
    MessagesComponent,
    UserMessagesComponent,

    SendMessageComponent,

    CompanyPostProfileComponent,

      FollowRequestsComponent,
      FollowRequestComponent,

     PopUpLikeDislikeComponent,
     PopUpLikedComponent,
     ChatComponent,
     AllPostFromFollowingComponent,
     ViewConnectionsComponent,
     ViewConnectionComponent,
     ViewChatComponent,
     ViewChatOnelineComponent,
     ReplyMessageComponent



  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatIconModule,
    BrowserAnimationsModule,
    CommonModule,ReactiveFormsModule,
    MatDialogModule,
    MatCardModule,
    MatTabsModule,
    MatButtonModule,
    MatToolbarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
