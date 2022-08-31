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
import {Message} from "../model/message";
import {MessageDTO} from "../model/MessageDTO";
import {MessagingService} from "../../service/messaging.service";
import {FollowReqService} from "../../service/follow-req.service";
import {IsFollowingDTO} from "../model/IsFollowingDTO";



@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {


  user:User;
  followedUser : User;
  toFollowUsername: string;

  sender:string;
  reciever:string;
  retMsg: Message;
  sendMess: MessageDTO;

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
  enabledFollow:boolean = true;
  alreadyFollowing:boolean = false;
  showIfuserIsLongin:boolean;

  tmpId1:any;
  tmpId2:number;
  tmpUser1:User;
  tmpUser2:User;

  ifDTO: IsFollowingDTO;
  profileType:ProfileType;

  listsOfBlockedUser:string[];
  isUserBlockedMessageButton:boolean=false;






  constructor(private route: ActivatedRoute,private profileService: ProfileService,private userPostService: UserPostService,private messageService: MessagingService, private followingService:FollowReqService) {
    this.fDTO = new FollowRequestsDTO({
      followerId: '',
      toFollowId: ''
    })
    this.ifDTO = new IsFollowingDTO({
      id1:0,
      id2:0
    })
    this.user=new User({
      id:0,
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
      id:0,
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
        id:0,
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
    }),
      this.sendMess = new MessageDTO({
        senderUsername: '',
        recieverUsername: '',
        message: ''
      });
  }

  ngOnInit(): void {

    this.idLoginUser = sessionStorage.getItem('id');
    if(this.idLoginUser==null){
      this.showIfuserIsLongin=false;
    }else{
      this.showIfuserIsLongin=true;
    }
    this.loadProfile();
    this.loadUser();
    this.isFollowing();
  }

  loadClient(){
    console.log(this.id);
    this.id = this.route.snapshot.params['id'];
    this.profileService.getUser(this.id)
      .subscribe(res =>{
        this.user = res;
        console.log(res.profileType)
        /*if(res.profileType.valueOf()===ProfileType.Private.valueOf()){
          this.showAllInformation=false;
        }else{
          this.showAllInformation=true;
        }*/
      }
      )
  }
  loadProfile(){
    this.id = this.route.snapshot.params['id'];
    this.profileService.getProfile(this.id)
      .subscribe(res=>{

        this.profile=res;
        //this.a(res.user.blocked);
        console.log(res.user.profileType)

        console.log("ceo rpofil",res)
        this.isUserPublicAndIsInFollowingWithLoginUser(res);
        this.ifDTO.id2 = res.user.id;
        this.profileType=res.user.profileType;
        this.userPostService.searchPostByUser(this.id)
        .subscribe(res=>this.posts=res)
      })

  }


  isFollowing(){
    this.tmpId2 = this.route.snapshot.params['id'];
    this.tmpId1 = sessionStorage.getItem('id');
    this.ifDTO.id2 = this.tmpId2;
    this.ifDTO.id1 = this.tmpId1;
    this.followingService.isFollowing(this.ifDTO).subscribe(res => {
      this.alreadyFollowing = res;
    });
  }

//ako je user public ili ako se vec pretai sa ulogovanim userom, onda treba prikazati i ostale informacije na profilu
  isUserPublicAndIsInFollowingWithLoginUser(profile:Profile){
    if(profile.user.profileType.toString()=="PRIVATE" && !this.isUserFollowingWithLOginUser(profile.user.following)){
      this.showAllInformation=false;
      this.showUserPosts=false;
    }else{
      this.showAllInformation=true;
    }
  }
  isUserFollowingWithLOginUser(listsFollowers:string[]):boolean{
    var usernameLoginUser=sessionStorage.getItem('username');
    console.log("ovo je username od ulogovanog",usernameLoginUser)
    console.log(listsFollowers)
    for(var val of listsFollowers){
      if(val==usernameLoginUser){
        return true;
      }
    }
    return false;

  }
  checkProfileType(){
    if(this.user.profileType==ProfileType.Private){
      this.showAllInformation=false;
    }else{
      this.showAllInformation=true;
    }
  }
  isUserBlocked(){
    this.followingService.getBlocked(this.id).subscribe(res=>
      this.a(res)
    );
  }
  a(listsOfBlockedUsername:string[]){
    for(var val of listsOfBlockedUsername){
      if(val==this.profile.user.username){
        this.isUserBlockedMessageButton=true;
    }
    this.isUserBlockedMessageButton=false;
  }
}

  loadUser(){
    this.idLoginUser = sessionStorage.getItem('id');
    //console.log(this.idLoginUser)
    this.profileService.getUser(this.idLoginUser)
      .subscribe(res => {
          this.loggedUser = res;
          this.ifDTO.id1 = res.id;
        }
      )
    this.reciever = this.route.snapshot.params['id'];
    this.sender = this.idLoginUser;
  }

  followUser() {
    this.fDTO.followerId = this.loggedUser.username;
    this.fDTO.toFollowId = this.profile.user.username;
    this.profileService.followUser(this.fDTO).subscribe(res => this.followedUser = res);
    this.profileService.followUserFromPR(this.fDTO).subscribe(res => this.followedUser = res);
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


  /*
  sendMessage(){
    this.sendMess.senderUsername = this.route.snapshot.params['fid'];
    this.sendMess.recieverUsername = this.route.snapshot.params['id'];
    this.sendMess.message = this.msg;
    this.sendMess.sendMessage(this.messToSend).subscribe(res => this.sendMsg = res);
  }

   */
}
