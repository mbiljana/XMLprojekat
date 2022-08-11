import { MakeNewUserPostComponent } from './make-new-user-post/make-new-user-post.component';
import { UserPersonalProfileComponent } from './user-personal-profile/user-personal-profile.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { SignInPageComponent } from './sign-in-page/sign-in-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { SearchComponent } from './search/search.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainPageComponent } from './main-page/main-page.component';

const routes: Routes = [
  { path: '', component: MainPageComponent},
  { path: 'search', component: SearchComponent},
  { path:'register',component:RegisterPageComponent},
  { path:'sign-in',component:SignInPageComponent},
  { path:'search/profile/:id',component:UserProfileComponent}
  { path:'search/profile/:id',component:UserProfileComponent},
  { path:'profile/:id',component:UserPersonalProfileComponent},
  { path:'profile/:id/newPost',component:MakeNewUserPostComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
