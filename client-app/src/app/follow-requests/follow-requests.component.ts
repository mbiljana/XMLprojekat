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

  id:number;
  idLoginUser:any;
  loggedUser:User;
  foundUser: UsersFollowRequestsDTO;
  username:string;


  @Input()
  requests: string[];

  constructor(private route: ActivatedRoute, private requestService: FollowReqService,private profileService: ProfileService ) {

    this.foundUser = new UsersFollowRequestsDTO({
      username : ''
    });
  }
  ngOnInit() {
    this.loadUser();
  }

  loadUser(){
    this.id = this.route.snapshot.params['id'];
    //this.idLoginUser = sessionStorage.getItem('id');
    this.profileService.getUser(this.id)
      .subscribe(res =>{
          this.loggedUser = res;
          this.requestService.getUsersFollowRequests(this.id).subscribe(res=> this.requests=res);
      }

      )
    console.log(this.id);
  }


  loadRequests(){

    //console.log(this.loggedUser.username);
  }
    /*
    this.foundUser.username = this.loggedUser.username;
    this.requestService.getUsersFollowRequests(this.foundUser).subscribe(res=> this.requests=res);
    }

     */

}
