import {Component, Input, OnInit} from '@angular/core';
import {UsersFollowRequestsDTO} from "../model/UsersFollowRequestsDTO";
import {User} from "../model/user";
import {FollowRequestsDTO} from "../model/FollowRequestsDTO";
import {ActivatedRoute} from "@angular/router";
import {FollowReqService} from "../../service/follow-req.service";
import {UserService} from "../../service/user.service";
import {ProfileType} from "../model/profileType";
import {ProfileService} from "../../service/profile.service";

@Component({
  selector: 'tr[app-follow-request]',
  templateUrl: './follow-request.component.html',
  styleUrls: ['./follow-request.component.css']
})
export class FollowRequestComponent implements OnInit {


  idLoginUser:any;
  user:User;

  fDTO: FollowRequestsDTO;
  retVal : string;
  retUser:User;
  loggedUsername:string;
  loggedId:number;
  id:number;

  retUsr:string;
  retFlw:string;

  @Input()
  public request : string;

  constructor(private route: ActivatedRoute, private followService: FollowReqService, private profileService:ProfileService) {
    this.request = '';
   // this.follower = '';
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
      role:'',
      firstLogin:false,
      following:[],
      followRequests:[]
    }),
      this.fDTO = new FollowRequestsDTO({
        followerId:'',
        toFollowId:''
      }),
      this.retUser=new User({
        id:0,
        firstName: '',
        lastName: '',
        username: '',
        password: '',
        email: '',
        mobile: '',
        gender:'',
        profileType:ProfileType.Private,
        role:'',
        firstLogin:false,
        following:[],
        followRequests:[]
      });
  }

  ngOnInit(): void {
    this.findUser();
  }

  findUser(){
    this.profileService.getUserByUsername(this.request).subscribe(res => this.user=res);
    this.id = this.route.snapshot.params['id'];
    this.profileService.getUser(this.id).subscribe(res => this.retUser  =res);
  }

  acceptRequest(){
    this.retUsr = this.retUser.username;
    this.retFlw = this.request;
    this.followService.acceptRequest(this.retUsr,this.retFlw).subscribe();
  }



}
