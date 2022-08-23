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

  constructor(private registrationService:RegistrationService, private router:Router) { }
  error: string;

  ngOnInit(): void {
  }
  newUser: User = new User({
    id: 0,
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    mobile: '',
    profilePicture:'',
    gender:'',
    role:'',
    firstLogin:false
  });
  genders=['female','male'];
  confirmedPassword: string;
  showForm: boolean = true;

  registrationRequest: UserRequest = new UserRequest({
    id: 0,
    korisnicko: this.newUser.username,
    password: this.newUser.password,
    firstName: this.newUser.firstName,
    lastName: this.newUser.lastName,
    gender:this.newUser.gender
  })


  addNewUser(){
    if (this.newUser.password == this.confirmedPassword) {
      this.registrationRequest.korisnicko = this.newUser.username;
      this.registrationRequest.password = this.newUser.password;
      this.registrationRequest.firstName = this.newUser.firstName;
      this.registrationRequest.lastName = this.newUser.lastName;
      this.registrationRequest.gender = this.newUser.gender;
      this.registrationService.registerUser(this.registrationRequest).subscribe(res => this.newUser = res);
    } else {
      this.error = "passwords are not equal";
    }

  }
}
