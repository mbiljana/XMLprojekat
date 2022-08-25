import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ProfileService} from "../../service/profile.service";
import {ConnectionsService} from "../../service/connections.service";
import {User} from "../model/user";
import {UserPostService} from "../../service/user-post.service";
import {CommentService} from "../../service/comment.service";
import {Profile} from "../model/profile";
import {ProfileType} from "../model/profileType";
import {ConnectionsNumberDTO} from "../model/ConnectionsNumberDTO";
import {UserService} from "../../service/user.service";
import {FollowRequestsDTO} from "../model/FollowRequestsDTO";
import {UsersFollowRequestsDTO} from "../model/UsersFollowRequestsDTO";
import {FollowReqService} from "../../service/follow-req.service";

@Component({
  selector: 'app-view-connections-block',
  templateUrl: './view-connections-block.component.html',
  styleUrls: ['./view-connections-block.component.css']
})

export class ViewConnectionsBlockComponent implements OnInit {

  id: number;
  loggedUser: User;
  profile: Profile;
  fDTO:FollowRequestsDTO;
  foundUser:UsersFollowRequestsDTO;

  @Input()
  blocks: string[];


  constructor(private route: ActivatedRoute, private profileService: ProfileService, private connectionService:ConnectionsService, private userService:UserService, private followService: FollowReqService) {
    this.foundUser = new UsersFollowRequestsDTO({
      username: ''
    });
  }
  ngOnInit(): void {
    this.loadUser();
  }

  loadUser(){
    this.id = this.route.snapshot.params['id'];
    //this.idLoginUser = sessionStorage.getItem('id');
    this.profileService.getUser(this.id)
      .subscribe(res =>{
          this.loggedUser = res;
          //this.connectionService.getUsersConnections(this.id).subscribe(res=> this.block=res);
          this.followService.getBlocked(this.id).subscribe(res => this.blocks=res);
        }

      )
    //console.log(this.id);
  }


}

