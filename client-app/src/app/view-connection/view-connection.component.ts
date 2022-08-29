import {Component, Input, OnInit} from '@angular/core';
import {User} from "../model/user";
import {ActivatedRoute, Router} from "@angular/router";
import {FollowReqService} from "../../service/follow-req.service";
import {ProfileService} from "../../service/profile.service";
import {ConnectionsService} from "../../service/connections.service";
import {ProfileType} from "../model/profileType";
import {UserService} from "../../service/user.service";
import {FollowRequestsDTO} from "../model/FollowRequestsDTO";
import {Profile} from "../model/profile";

@Component({
  selector: '[app-view-connection]',
  templateUrl: './view-connection.component.html',
  styleUrls: ['./view-connection.component.css']
})
export class ViewConnectionComponent implements OnInit {


  idLoginUser:any;
  user:User;
  follower: string;
  fDTO:FollowRequestsDTO;
  retUser:User;
  profile:Profile;
  id:number;

  retUsr:String;
  retFlw:String;

  @Input()
  public connection : string;

  constructor(private router:Router,private route: ActivatedRoute, private followService: FollowReqService, private connectionService: ConnectionsService, private profileService:ProfileService, private userService:UserService) {
    this.connection = '';
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
      followRequests:[],
      blocked:[]
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
        followRequests:[],
        blocked:[]
      });

  }

  ngOnInit(): void {
    this.findUser();
  }

  findUser(){
    this.profileService.getUserByUsername(this.connection).subscribe(res => this.user=res);
    this.id = this.route.snapshot.params['id'];
    this.profileService.getUser(this.id).subscribe(res => this.retUser = res);
  }

  blockUser(){
    this.retUsr = this.retUser.username;
    this.retFlw = this.connection;
    this.fDTO.toFollowId = this.retFlw;
    this.fDTO.followerId = this.retUsr;
    this.followService.block(this.fDTO).subscribe(res => this.retFlw = res);
    this.followService.blockProfile(this.fDTO).subscribe(res => this.retFlw = res);
    //console.log(this.fDTO);

      this.router.navigate(['profile',this.retUser.id])
    }

}
