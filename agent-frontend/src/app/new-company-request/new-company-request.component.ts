import { CompanyRequest } from './../model/companyRequest';
import { UserService } from './../../service/user.service';
import { CompanyService } from './../../service/company.service';
import { Company } from './../model/company';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Address } from '../model/address';
import { User } from '../model/user';
import { CompanyRequestService } from 'src/service/company-request.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-company-request',
  templateUrl: './new-company-request.component.html',
  styleUrls: ['./new-company-request.component.css']
})
export class NewCompanyRequestComponent implements OnInit {
  makedCompany:boolean=false;
  showMakeCompany:boolean=true;
  selectedFile: File;
  idLoginUser:any;
  newRequest:CompanyRequest;

  constructor(private http: HttpClient,private companyRequestService: CompanyRequestService, private userService: UserService,private router: Router) {
    this.newRequest=new CompanyRequest({
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
          firstLogin:false
        })
      })
    })
  }

  ngOnInit(): void {
    this.loadUser();
  }
  sendRequsest(){
    var path_picture="/assets/companyPicture/"+this.selectedFile.name;


    this.newRequest.company.profilePicture=path_picture;

    this.companyRequestService.save(this.newRequest)
    .subscribe()
    this.makedCompany=true;
    this.showMakeCompany=false;
  }
  backToProfile(){
    this.router.navigate(['profile', this.idLoginUser]);
  }
  loadUser(){
    this.idLoginUser = sessionStorage.getItem('id');
    console.log(this.idLoginUser)
    this.userService.getUser(this.idLoginUser)
    .subscribe(res =>{
      this.newRequest.company.owner = res;
    }
    )
}
  onUpload() {
    console.log(this.selectedFile);

    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();
    uploadImageData.append('file', this.selectedFile, this.selectedFile.name);
    this.http.post('http://localhost:8083/upload', uploadImageData)
      .subscribe((response) => {

      }
      );
  }

  public onFileChanged(event: any) {
    this.selectedFile = event.target.files[0];
  }
}
