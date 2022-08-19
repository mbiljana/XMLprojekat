import { UserPostProfileComponent } from './user-post-profile/user-post-profile.component';
import { AllPostFromFollowingComponent } from './all-post-from-following/all-post-from-following.component';
import { AddCommentComponent } from './add-comment/add-comment.component';

import { MakeNewUserPostComponent } from './make-new-user-post/make-new-user-post.component';
import { UserPersonalProfileComponent } from './user-personal-profile/user-personal-profile.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { SignInPageComponent } from './sign-in-page/sign-in-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { SearchComponent } from './search/search.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainPageComponent } from './main-page/main-page.component';
import {MessagesComponent} from "./messages/messages.component";
import {FollowRequestsComponent} from "./follow-requests/follow-requests.component";
import {ViewConnectionsComponent} from "./view-connections/view-connections.component";

const routes: Routes = [
  { path: '', component: MainPageComponent},
  { path:'allPost',component:AllPostFromFollowingComponent},
  { path: 'search', component: SearchComponent},
  { path:'register',component:RegisterPageComponent},
  { path:'sign-in',component:SignInPageComponent},
  {path: 'messages', component: MessagesComponent},
  { path:'search/profile/:id',component:UserProfileComponent},
  { path:'profile/:id',component:UserPersonalProfileComponent},
  { path:'profile/:id/newPost',component:MakeNewUserPostComponent},
  { path:'search/profile/:id/newComment/:postId',component:AddCommentComponent},
  { path:'profile/:id/newComment/:postId',component:AddCommentComponent},

  { path:'allPost/newComment/:postId',component:AddCommentComponent},
  { path:"allPost/detailsUserPost/:postId",component:UserPostProfileComponent},

  {path:'requests', component: FollowRequestsComponent},
  {path:'profile/:id/requests', component: FollowRequestsComponent},
  {path:'profile/:id/requests/profile/:id', component: UserProfileComponent},
  {path:'profile/:id/view-connections', component:ViewConnectionsComponent},
  {path:'profile/:id/view-connections/profile/:id', component:UserProfileComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
