import {Component, Input, OnInit} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {Observable} from "rxjs";
import {Message} from "../model/message";
import {FollowReqService} from "../../service/follow-req.service";
import {FollowRequestsDTO} from "../model/FollowRequestsDTO";
import {UsersFollowRequestsDTO} from "../model/UsersFollowRequestsDTO";
import {User} from "../model/user";
import {ProfileService} from "../../service/profile.service";
import {waitForAsync} from "@angular/core/testing";

@Component({
  selector: 'app-follow-requests',
  templateUrl: './follow-requests.component.html',
  styleUrls: ['./follow-requests.component.css']
})
export class FollowRequestsComponent implements OnInit {

  idLoginUser:any;
  loggedUser:User;
  foundUser: UsersFollowRequestsDTO;
  username:string;


  @Input()
  requests: String[];

  constructor(private route: ActivatedRoute, private requestService: FollowReqService,private profileService: ProfileService ) {
    this.foundUser = new UsersFollowRequestsDTO({
      username:''
    });
  }



  ngOnInit() {
    this.loadUser();
   //this.loadRequests(1000);
  }


  loadUser(){
    this.idLoginUser = sessionStorage.getItem('id');
    this.profileService.getUser(this.idLoginUser)
      .subscribe(res =>
        this.loggedUser = res
      );
    console.log("user found" + this.loggedUser.username);
  }

  loadRequests(){
    this.foundUser = new UsersFollowRequestsDTO({
      username : this.loggedUser.username
    });
    //this.foundUser = new UsersFollowRequestsDTO({username : 'maja'});
    this.requestService.getUsersFollowRequests(this.foundUser).subscribe(res=> this.requests=res);
  }

}
