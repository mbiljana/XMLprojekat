import { Company } from './../model/company';
import { CompanyService } from './../../service/company.service';
import { UserSearch } from './../model/userSearch';
import { ProfileService } from './../../service/profile.service';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { User } from '../model/user';

@Component({
  selector: 'app-search-profile',
  templateUrl: './search-profile.component.html',
  styleUrls: ['./search-profile.component.css']
})
export class SearchProfileComponent implements OnInit {
  name:string;
  fname:string;
  lname:string;
  company_name:string;
  choices_for_search=['user','company'];
  who_to_search:string;

  @Output()
  UserSearched: EventEmitter<User[]>=new EventEmitter();

  @Output()
  CompanySearched: EventEmitter<Company>=new EventEmitter();

  constructor(private profileService:ProfileService,private companyService:CompanyService) { }

  user: UserSearch = new UserSearch({
    firstName: '',
    lastName: ''
  });

  ngOnInit(): void {
  }
  searcUserByFirstNameAndLastName(){
    if (this.who_to_search=="user"){
      const list=this.name.split(" ");
      this.fname=list[0];
      this.lname=list[1];
      this.user.firstName=this.fname;
      this.user.lastName=this.lname;
      this.profileService.searchUserByFirstAndLastName(this.user)
      .subscribe(res=>this.UserSearched.next(res));
    }else{
      this.companyService.searchCompanyName(this.name)
      .subscribe(res=>this.CompanySearched.next(res));
    }
  }

}
