import { ProfileType } from './../model/profileType';
import { Profile } from './../model/profile';
import { ActivatedRoute } from '@angular/router';
import { ProfileService } from './../../service/profile.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import {UserPost} from "../model/userPost";
import {UserPostService} from "../../service/user-post.service";
import {CommentService} from "../../service/comment.service";
import { ThisReceiver } from '@angular/compiler';
import {ProgramLanguage} from "../model/programLanguage";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-user-personal-profile-update',
  templateUrl: './user-personal-profile-update.component.html',
  styleUrls: ['./user-personal-profile-update.component.css']
})

export class UserPersonalProfileUpdateComponent implements OnInit {

  profile:Profile;
  id:number;
  posts:UserPost[];
  post:UserPost;
  selectedFile: File;
  showUserPosts:boolean=true;
  showHolePost:boolean=false;

  constructor(private route: ActivatedRoute,private http: HttpClient,private profileService: ProfileService,private userPostService: UserPostService,private commentService:CommentService) {
    this.posts=[]
    this.profile=new Profile({
      user:new User({
        id:0,
        firstName: '',
        lastName: '',
        username: '',
        password: '',
        email: '',
        mobile: '',
        gender:'',
        dateOfBirth:'',
        profileType:ProfileType.Private,
        role:'',
        firstLogin:false,
        following:[],
        followRequests:[]

      }),
      proramLanguages:[],
      exCompanies:[],
      languages:[],
      education:'',
      additionInformation:'',
      profileType:ProfileType.Private
    });
  }

  ngOnInit(): void {
    this.loadProfile();
  }
  loadProfile(){
    this.id = this.route.snapshot.params['id'];
    this.profileService.getProfile(this.id)
      .subscribe(res=>{
        this.profile=res;
        this.userPostService.searchPostByUser(this.id)
          .subscribe(res=>this.posts=res)
      })
  }

  public onFileChangedPhoto(event: any) {
    this.selectedFile = event.target.files[0];
  }
  onUploadPhoto() {
    console.log(this.selectedFile);

    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();
    uploadImageData.append('file', this.selectedFile, this.selectedFile.name);
    this.http.post('http://localhost:8080/upload', uploadImageData)
      .subscribe((response) => {

        }
      );
  }

  saveChanges(){
  this.profileService.updateProfile(this.profile)
    .subscribe()
  }

}
