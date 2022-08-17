import { ProgramLanguage } from './../model/programLanguage';
import { ProfileService } from './../../service/profile.service';
import { ProfileType } from './../model/profileType';
import { User } from 'src/app/model/user';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Profile } from '../model/profile';
import { FollowRequestsDTO} from "../model/FollowRequestsDTO";

import { UserPost } from '../model/userPost';
import { UserPostService } from 'src/service/user-post.service';



@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {


  user:User;
  followedUser : User;
  toFollowUsername: string;

  profile:Profile;
  posts:UserPost[];
  post:UserPost;
  currentUser:Profile;
  loggedUser:User;

  fDTO: FollowRequestsDTO;


  id:number;
  idLoginUser:any;
  compare=ProfileType.Private;

  showAllInformation:boolean=false;
  showUserPosts:boolean=true;
  showHolePost:boolean=false;




  constructor(private route: ActivatedRoute,private profileService: ProfileService,private userPostService: UserPostService) {
    this.fDTO = new FollowRequestsDTO({
      followerId: '',
      toFollowId: ''
    })
    this.user=new User({
      firstName: '',
      lastName: '',
      username: '',
      password: '',
      email: '',
      mobile: '',
      gender:'',
      profileType:ProfileType.Private,
      firstLogin:false,
      role:'',
      following:[],
      followRequests:[]
    });
    this.followedUser = new User({
      firstName: '',
      lastName: '',
      username: '',
      password: '',
      email: '',
      mobile: '',
      gender:'',
      profileType:ProfileType.Private,
      firstLogin:false,
      role:'',
      following:[],
      followRequests:[]
    });
    this.profile=new Profile({
      user:new User({
        firstName: '',
        lastName: '',
        username: '',
        password: '',
        email: '',
        mobile: '',
        gender:'',
        profileType:ProfileType.Private,
        firstLogin:false,
        role:'',
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
    this.loadUser();
  }

  loadClient(){
    console.log(this.id);
    this.id = this.route.snapshot.params['id'];
    this.profileService.getUser(this.id)
      .subscribe(res =>{
        this.user = res;
        console.log(res.profileType)
        if(res.profileType.valueOf()===ProfileType.Private.valueOf()){
          this.showAllInformation=false;
        }else{
          this.showAllInformation=true;
        }
      }
      )
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
  checkProfileType(){
    if(this.user.profileType==ProfileType.Private){
      this.showAllInformation=false;
    }else{
      this.showAllInformation=true;
    }
  }

  loadUser(){
    this.idLoginUser = sessionStorage.getItem('id');
    //console.log(this.idLoginUser)
    this.profileService.getUser(this.idLoginUser)
      .subscribe(res =>
        this.loggedUser = res
      )
  }

  followUser() {
    this.fDTO.followerId = this.loggedUser.username;
    this.fDTO.toFollowId = this.profile.user.username;
    this.profileService.followUser(this.fDTO).subscribe(res => this.followedUser = res);
  }

  viewHolePost(post:UserPost){
    this.showHolePost=true;
    this.post=post;
    console.log(post)
    this.showUserPosts=false;
  }
  showAllPosts(){
    this.loadProfile();
    this.showUserPosts=true;
    this.showHolePost=false;
  }
}
