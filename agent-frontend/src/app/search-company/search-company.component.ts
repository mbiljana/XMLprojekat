import { CompanyService } from 'src/service/company.service';
import { Component, OnInit } from '@angular/core';
import { Address } from '../model/address';
import { Company } from '../model/company';
import { User } from '../model/user';

@Component({
  selector: 'app-search-company',
  templateUrl: './search-company.component.html',
  styleUrls: ['./search-company.component.css']
})
export class SearchCompanyComponent implements OnInit {
  company:Company;
  name:string;
  showFoundCompany:boolean=false;

  constructor(private companyService:CompanyService) {
    this.company=new Company({
      id:0,
      name:'',
      description:'',
      address:new Address({
        city:'',
        state:'',
        street:''
      }),
      username:'',
      email:'',
      mobile:'',
      profilePicture:'',
      owner:new User({
        id:0,
        firstName: '',
        lastName: '',
        username: '',
        password: '',
        email: '',
        mobile: '',
        gender:'',
        role:'',
        firstLogin:false
      })
    })
   }

  ngOnInit(): void {
  }
  searchCompanyName(){
    this.companyService.findByName(this.name)
    .subscribe(res=>{this.company=res;this.showFoundCompany=true;})
  }
  viewProfile(){}
}
