import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


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
    PostItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
