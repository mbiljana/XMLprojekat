import { Component, OnInit } from '@angular/core';
import {Company} from "../model/company";
import {UpdateCompany} from "../model/company-update";
import {ActivatedRoute} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {CompanyService} from "../../service/company.service";
import {Address} from "../model/address";
import {User} from "../model/user";

@Component({
  selector: 'app-update-company',
  templateUrl: './update-company.component.html',
  styleUrls: ['./update-company.component.css']
})
export class UpdateCompanyComponent implements OnInit {

  company:Company;
  user:User;
  updateCompany: UpdateCompany;
  id:number;

  constructor(private route: ActivatedRoute,private http: HttpClient, private companyService: CompanyService) {
    this.company = new Company({
      id:0,
      name:'',
      description:'',
      address: new Address({
        state:'',
        street:'',
        city:''
      }),
      username:'',
      email:'',
      mobile:'',
      profilePicture:'',
      owner:this.user
    });
    this.updateCompany = new UpdateCompany({
      id:0,
      name:'',
      description:'',
      address: new Address({
        state:'',
        street:'',
        city:''
      }),
      username:'',
      email:'',
      mobile:''
    })
  }

  ngOnInit(): void {
    this.loadCompany();
  }

  loadCompany(){
    this.id = this.route.snapshot.params['id'];
    this.companyService.getOneByOwnerId(this.id).subscribe(res => this.company = res);
  }

  saveChanges(){
    /*
    this.updateCompany.mobile = this.company.mobile;
    this.updateCompany.email = this.company.email;
    this.updateCompany.id = this.company.id;
    this.updateCompany.name = this.company.name;
    this.updateCompany.address = this.company.address;
    this.updateCompany.description = this.company.description;
    this.updateCompany.username = this.company.username;

     */
    this.companyService.updateCompany(this.company)
      .subscribe()
  }

}
