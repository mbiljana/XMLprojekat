import { CompanyService } from 'src/service/company.service';
import { Component, OnInit } from '@angular/core';
import { Address } from '../model/address';
import { Company } from '../model/company';
import { User } from '../model/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-company',
  templateUrl: './search-company.component.html',
  styleUrls: ['./search-company.component.css']
})
export class SearchCompanyComponent implements OnInit {
  company:Company;
  name:string;
  showFoundCompany:boolean=false;

  constructor(private companyService:CompanyService,private router: Router) {
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
        roleType:'',
        roles:[],
        firstLogin:false
      }),
      grades:[],
      salaries:[]
    })
   }

  ngOnInit(): void {
  }
  searchCompanyName(){
    this.companyService.findByName(this.name)
    .subscribe(res=>{this.company=res;this.showFoundCompany=true;})
  }
  viewProfile(){
    this.router.navigate(['company', this.company.id])
  }
}
