import { Component, OnInit } from '@angular/core';
import {RegistrationService} from "../../service/registration.service";
import {Router} from "@angular/router";
import {User} from "../model/user";
import {UserRequest} from "../model/UserRequest";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {

  newUser: User;
  retUser:User;
  registrationRequest: UserRequest;
  selectedFile: File;
  constructor(private registrationService:RegistrationService, private router:Router,private http: HttpClient) {
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
      mobile:'',
      profilePicture:''
    });
  }
  error: string;

  ngOnInit(): void {
  }

  genders=['female','male'];
  confirmedPassword: string;
  showForm: boolean = true;


  addNewUser(){
    var path_picture="/assets/profilePicture/"+this.selectedFile.name;
    if (this.newUser.password == this.confirmedPassword) {
      this.registrationRequest.korisnicko = this.newUser.username;
      this.registrationRequest.profilePicture = path_picture;
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
