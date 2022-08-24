import { Component, OnInit } from '@angular/core';
import {User} from "../model/user";
import {UpdateUser} from "../model/udate-user";
import {ActivatedRoute} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {UserService} from "../../service/user.service";

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {

  user:User;
  updateUser:UpdateUser;
  selectedFile: File;
  id:number;


  constructor(private route: ActivatedRoute,private http: HttpClient, private userService: UserService) {
    this.user = new User({
      id:0,
      firstName:'',
      lastName:'',
      username:'',
      password:'',
      email:'',
      mobile:'',
      profilePicture:'',
      gender:'',
      roles:[],
      roleType:'',
      firstLogin:false
    });
    this.updateUser = new UpdateUser({
      id:0,
      firstName:'',
      lastName:'',
      username:'',
      password:'',
      email:'',
      mobile:'',
      profilePicture:''
    });
  }

  ngOnInit(): void {
    this.loadUser();
  }

  loadUser(){
    this.id = this.route.snapshot.params['id'];
    this.userService.getUser(this.id).subscribe(res => this.user = res);
  }

  public onFileChangedPhoto(event: any) {
    this.selectedFile = event.target.files[0];
  }
  onUploadPhoto() {
    console.log(this.selectedFile);
    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();
    uploadImageData.append('file', this.selectedFile, this.selectedFile.name);
    this.http.post('http://localhost:8083/upload', uploadImageData)
      .subscribe((response) => {
        }
      );
  }

  saveChanges(){
    this.userService.updateUser(this.user)
      .subscribe()
  }

}
