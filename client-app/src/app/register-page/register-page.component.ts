import { User } from './../model/user';
import { Component, OnInit } from '@angular/core';
import { ProfileType } from '../model/profileType';
import {UserRequest} from "../model/UserRequest";
import {RegistrationService} from "../../service/registration.service";
import {Router} from "@angular/router";
import {ProfileService} from "../../service/profile.service";
import {UserService} from "../../service/user.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {


  selectedFile: File;

  constructor(private registrationService:RegistrationService, private router:Router, private profileService: ProfileService, private userService:UserService,private http: HttpClient) {
  }

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
    firstLogin:false,
    following:[],
    followRequests:[]
  });
  genders=['female','male'];
  confirmedPassword: string;
  error: string;
  showForm: boolean = true;

  registrationRequest: UserRequest = new UserRequest({
    id: 0,
    korisnicko: this.newUser.username,
    password: this.newUser.password,
    firstname: this.newUser.firstName,
    lastname: this.newUser.lastName,
    gender:this.newUser.gender,
    profilePicture:''
  })


  /*
  const express = require('express');
const request = require('request');

const app = express();

app.use((req, res, next) => {
  res.header('Access-Control-Allow-Origin', '*');
  next();
});

app.get('/jokes/random', (req, res) => {
  request(
    { url: 'https://joke-api-strict-cors.appspot.com/jokes/random' },
    (error, response, body) => {
      if (error || response.statusCode !== 200) {
        return res.status(500).json({ type: 'error', message: err.message });
      }

      res.json(JSON.parse(body));
    }
  )
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => console.log(`listening on ${PORT}`));
   */



  addNewUser(){
    var path_picture="/assets/profilePicture/"+this.selectedFile.name;
    if (this.newUser.password == this.confirmedPassword) {
      this.registrationRequest.korisnicko = this.newUser.username;
      this.registrationRequest.password = this.newUser.password;
      this.registrationRequest.firstname = this.newUser.firstName;
      this.registrationRequest.lastname = this.newUser.lastName;
      this.registrationRequest.gender = this.newUser.gender;
      this.registrationRequest.profilePicture = path_picture;
      this.registrationService.registerUser(this.registrationRequest).subscribe(res => {
        this.newUser = res;
        this.profileService.createProfile(res).subscribe();
        this.userService.saveUser(res).subscribe();
      });

    } else {
      this.error = "passwords are not equal";
    }

  }

  onUpload() {
    console.log(this.selectedFile);

    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();
    uploadImageData.append('file', this.selectedFile, this.selectedFile.name);
    this.http.post('http://localhost:8082/upload', uploadImageData)
      .subscribe((response) => {
        }
      );
  }

  public onFileChanged(event: any) {
    this.selectedFile = event.target.files[0];
  }
}
