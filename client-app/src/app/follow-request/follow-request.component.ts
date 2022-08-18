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
  selector: '[app-follow-request]',
  templateUrl: './follow-request.component.html',
  styleUrls: ['./follow-request.component.css']
})
export class FollowRequestComponent implements OnInit {


  idLoginUser:any;
  user:User;
  follower: string;

  fDTO: FollowRequestsDTO;

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
    });

  }

  ngOnInit(): void {
    this.findUser();
  }

  findUser(){
    this.profileService.getUserByUsername(this.request).subscribe(res => this.user=res);
  }

  acceptRequest(){
    /*
    this.fDTO = new FollowRequestsDTO({
      followerId :this.loggedUser.username,
      toFollowId : JSON.stringify(this.request)
    });
    //this.fDTO.followerId = this.loggedUser.username;
    //this.fDTO.toFollowId = JSON.stringify(this.request);
    this.followService.acceptRequest(this.fDTO).subscribe(res => this.follower = res );

     */
  }



}
