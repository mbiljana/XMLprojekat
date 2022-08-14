import { User } from './../model/user';
import { Component, OnInit } from '@angular/core';
import { ProfileType } from '../model/profileType';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {

  constructor() { }

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
    profileType:ProfileType.Private,
    role:'',
    firstLogin:false
  });
  genders=['female','male'];
  confirmedPassword: string;
  error: string;
  showForm: boolean = true;
  addNewUser(){}
}
