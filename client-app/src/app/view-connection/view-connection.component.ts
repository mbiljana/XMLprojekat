import {Component, Input, OnInit} from '@angular/core';
import {User} from "../model/user";
import {ActivatedRoute} from "@angular/router";
import {FollowReqService} from "../../service/follow-req.service";
import {ProfileService} from "../../service/profile.service";
import {ConnectionsService} from "../../service/connections.service";
import {ProfileType} from "../model/profileType";
import {UserService} from "../../service/user.service";

@Component({
  selector: '[app-view-connection]',
  templateUrl: './view-connection.component.html',
  styleUrls: ['./view-connection.component.css']
})
export class ViewConnectionComponent implements OnInit {


  idLoginUser:any;
  user:User;
  follower: string;

  @Input()
  public connection : string;

  constructor(private route: ActivatedRoute, private connectionService: ConnectionsService, private profileService:ProfileService, private userService:UserService) {
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
      followRequests:[]
    });
  }

  ngOnInit(): void {
    this.findUser();
  }

  findUser(){
    this.profileService.getUserByUsername(this.connection).subscribe(res => this.user=res);
  }

  blockUser(){
    //this.userService.block().subscribe(
     // )
    ;}

}
