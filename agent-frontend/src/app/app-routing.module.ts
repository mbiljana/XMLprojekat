import { NewCompanyCommentComponent } from './new-company-comment/new-company-comment.component';
import { CompanySearchProfileComponent } from './company-search-profile/company-search-profile.component';
import { SearchCompanyComponent } from './search-company/search-company.component';
import { PostProfileComponent } from './post-profile/post-profile.component';
import { MakeNewPostComponent } from './make-new-post/make-new-post.component';
import { CompanyProfileComponent } from './company-profile/company-profile.component';
import { CompanyInterface } from './model/company';
import { OneRequestComponent } from './one-request/one-request.component';
import { CompanyRequestListComponent } from './company-request-list/company-request-list.component';
import { NewCompanyRequestComponent } from './new-company-request/new-company-request.component';
import { PersonalUserProfileComponent } from './personal-user-profile/personal-user-profile.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainPageComponent } from './main-page/main-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { SignInPageComponent } from './sign-in-page/sign-in-page.component';
import {UpdateProfileComponent} from "./update-profile/update-profile.component";
import {UpdateCompanyComponent} from "./update-company/update-company.component";

const routes: Routes = [

  { path: '', component: MainPageComponent},
  { path:'register',component:RegisterPageComponent},
  { path:'sign-in',component:SignInPageComponent},
  { path:'profile/:id',component:PersonalUserProfileComponent},
  {path:'profile/:id/update', component:UpdateProfileComponent},
  { path:'profile/:id/newCompanyRequest',component:NewCompanyRequestComponent},
  { path:'profile/:id/allRequests',component:CompanyRequestListComponent},
  { path:'profile/:id/allRequests/oneRequest/:idRequest',component:OneRequestComponent},
  { path:'profile/:id/company',component:CompanyProfileComponent},

  { path:'profile/:id/company/update',component:UpdateCompanyComponent},

  { path:'profile/:id/company/post/:postId',component:PostProfileComponent},
  { path:'profile/:id/company/newPost',component:MakeNewPostComponent},
  { path:'search',component:SearchCompanyComponent},
  { path:'company/:id', component:CompanySearchProfileComponent},
  { path:'company/:id/newComment', component:NewCompanyCommentComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
