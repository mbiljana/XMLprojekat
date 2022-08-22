import { CompanyRequestService } from 'src/service/company-request.service';
import { CompanyRequest } from 'src/app/model/companyRequest';
import { Component, OnInit } from '@angular/core';
import { Address } from '../model/address';
import { Company } from '../model/company';
import { User } from '../model/user';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-one-request',
  templateUrl: './one-request.component.html',
  styleUrls: ['./one-request.component.css']
})
export class OneRequestComponent implements OnInit {
  request:CompanyRequest;
  idRequest:number;
  constructor(private companyRequestService: CompanyRequestService,private route: ActivatedRoute,private router: Router) {
    this.request=new CompanyRequest({
      approved:false,
      company:new Company({
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
          firstLogin:false,

        })
      })
    })

   }

  ngOnInit(): void {
    this.loadRequest()
  }
  loadRequest(){
    this.idRequest = this.route.snapshot.params['idRequest'];
    this.companyRequestService.getOne(this.idRequest)
    .subscribe(res=>this.request=res)
  }
  backToAllRequest(){
    this.router.navigate(['profile', this.request.company.owner.id]);
  }
  approve(){
    this.request.approved=true;
    this.companyRequestService.approve(this.request)
    .subscribe(res=>this.request=res)
  }
}
