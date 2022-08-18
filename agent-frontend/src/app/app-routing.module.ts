import { NewCompanyRequestComponent } from './new-company-request/new-company-request.component';
import { PersonalUserProfileComponent } from './personal-user-profile/personal-user-profile.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainPageComponent } from './main-page/main-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { SignInPageComponent } from './sign-in-page/sign-in-page.component';

const routes: Routes = [

  { path: '', component: MainPageComponent},
  { path:'register',component:RegisterPageComponent},
  { path:'sign-in',component:SignInPageComponent},
  { path:'profile/:id',component:PersonalUserProfileComponent},
  { path:'profile/:id/newCompanyRequest',component:NewCompanyRequestComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
