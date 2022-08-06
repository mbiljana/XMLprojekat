import { Company } from './../model/company';
import { User } from 'src/app/model/user';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  showFoundUsers=false;
  foundUsers:User[];

  showFoundCompany=false;
  foundCompany:Company;

  showCompanyProfile=false;

  showSearchProfile=true;

  constructor() {
    this.foundUsers=[];
   }

  ngOnInit(): void {
  }
  searchUsers(users:User[]){
    this.foundUsers=users;
    this.showFoundCompany=false;
    this.showFoundUsers=true;
  }
  searchCompany(company:Company){
    this.foundCompany=company;
    this.showFoundUsers=false;
    this.showFoundCompany=true;
  }
  viewProfile(company:Company){
    this.showFoundCompany=false;
    this.showSearchProfile=false;
    this.showCompanyProfile=true;
  }

}
