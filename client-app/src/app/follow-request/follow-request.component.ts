import {Component, Input, OnInit} from '@angular/core';
import {UsersFollowRequestsDTO} from "../model/UsersFollowRequestsDTO";
import {User} from "../model/user";

@Component({
  selector: '[app-follow-request]',
  templateUrl: './follow-request.component.html',
  styleUrls: ['./follow-request.component.css']
})
export class FollowRequestComponent implements OnInit {


  idLoginUser:any;
  loggedUser:User;

  @Input()
  public request : String;

  constructor() {
    this.request = '';
  }

  ngOnInit(): void {
  }

  acceptRequest(){

  }

}
