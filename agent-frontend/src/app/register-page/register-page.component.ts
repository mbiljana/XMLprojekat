import { Component, OnInit } from '@angular/core';
import {RegistrationService} from "../../service/registration.service";
import {Router} from "@angular/router";
import {User} from "../model/user";
import {UserRequest} from "../model/UserRequest";

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {

  newUser: User;
  retUser:User;
  registrationRequest: UserRequest;
  constructor(private registrationService:RegistrationService, private router:Router) {
    this.newUser = new User({
      id: 0,
      username: '',
      password: '',
      firstName: '',
      lastName: '',
      email: '',
      mobile: '',
      profilePicture:'',
      gender:'',
      roles:[],
      roleType:'',
      firstLogin:false
    });
    this.retUser = new User({
      id: 0,
      username: '',
      password: '',
      firstName: '',
      lastName: '',
      email: '',
      mobile: '',
      profilePicture:'',
      gender:'',
      roles:[],
      roleType:'',
      firstLogin:false
    });
    this.registrationRequest= new UserRequest({
      id: 0,
      korisnicko: '',
      password: '',
      firstName: '',
      lastName: '',
      gender:'',
      email:'',
      mobile:''
    });
  }
  error: string;

  ngOnInit(): void {
  }

  genders=['female','male'];
  confirmedPassword: string;
  showForm: boolean = true;


  addNewUser(){
    if (this.newUser.password == this.confirmedPassword) {
      this.registrationRequest.korisnicko = this.newUser.username;
      this.registrationRequest.password = this.newUser.password;
      this.registrationRequest.firstName = this.newUser.firstName;
      this.registrationRequest.lastName = this.newUser.lastName;
      this.registrationRequest.gender = this.newUser.gender;
      this.registrationRequest.email = this.newUser.email;
      this.registrationRequest.mobile = this.newUser.mobile;
      this.registrationService.registerUser(this.registrationRequest).subscribe(res => this.retUser = res);
    } else {
      this.error = "passwords are not equal";
    }

  }
}
