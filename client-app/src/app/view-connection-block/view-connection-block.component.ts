import {Component, Input, OnInit} from '@angular/core';
import {User} from "../model/user";
import {ActivatedRoute} from "@angular/router";
import {FollowReqService} from "../../service/follow-req.service";
import {ProfileService} from "../../service/profile.service";
import {ConnectionsService} from "../../service/connections.service";
import {ProfileType} from "../model/profileType";
import {UserService} from "../../service/user.service";
import {FollowRequestsDTO} from "../model/FollowRequestsDTO";
import {Profile} from "../model/profile";

@Component({
  selector: '[app-view-connection-block]',
  templateUrl: './view-connection-block.component.html',
  styleUrls: ['./view-connection-block.component.css']
})
export class ViewConnectionBlockComponent implements OnInit {


  idLoginUser: any;
  user: User;
  follower: string;
  fDTO: FollowRequestsDTO;
  retUser: User;
  profile: Profile;
  id: number;

  retUsr: String;
  retFlw: String;

  @Input()
  public block: string;

  constructor(private route: ActivatedRoute, private connectionService: ConnectionsService, private profileService: ProfileService, private userService: UserService) {
    this.block = '';
    this.user = new User({
      id: 0,
      firstName: '',
      lastName: '',
      username: '',
      password: '',
      email: '',
      mobile: '',
      gender: '',
      profileType: ProfileType.Private,
      role: '',
      firstLogin: false,
      following: [],
      followRequests: [],
      blocked: []
    }),
      this.fDTO = new FollowRequestsDTO({
        followerId: '',
        toFollowId: ''
      }),
      this.retUser = new User({
        id: 0,
        firstName: '',
        lastName: '',
        username: '',
        password: '',
        email: '',
        mobile: '',
        gender: '',
        profileType: ProfileType.Private,
        role: '',
        firstLogin: false,
        following: [],
        followRequests: [],
        blocked: []
      });

  }

  ngOnInit(): void {
    this.findUser();
  }

  findUser(){
    this.profileService.getUserByUsername(this.block).subscribe(res => this.user=res);
    this.id = this.route.snapshot.params['id'];
    this.profileService.getUser(this.id).subscribe(res => this.retUser = res);
    //console.log(this.user);
  }

}
