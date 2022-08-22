import { Company } from './../model/company';
import { CompanyService } from './../../service/company.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Address } from '../model/address';
import { User } from '../model/user';

@Component({
  selector: 'app-company-profile',
  templateUrl: './company-profile.component.html',
  styleUrls: ['./company-profile.component.css']
})
export class CompanyProfileComponent implements OnInit {
  userId:any;
  company :Company;
  constructor(private companyService:CompanyService,private route: ActivatedRoute) {
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
    this.loadCompany();

  }
  loadCompany(){
    this.userId = this.route.snapshot.params['id'];
    this.companyService.getOneByOwnerId(this.userId)
    .subscribe(res=>this.company=res)
  }

}
