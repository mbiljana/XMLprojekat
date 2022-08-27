import { Component, OnInit } from '@angular/core';
import {Message} from "../model/message";
import {MessageDTO} from "../model/MessageDTO";
import {ActivatedRoute} from "@angular/router";
import {MessagingService} from "../../service/messaging.service";
import {UserService} from "../../service/user.service";
import {User} from "../model/user";
import {ProfileType} from "../model/profileType";
import {ProfileService} from "../../service/profile.service";

@Component({
  selector: 'app-send-message',
  templateUrl: './send-message.component.html',
  styleUrls: ['./send-message.component.css']
})
export class SendMessageComponent implements OnInit {

  msg:string;
  retMes: Message;
  sendMess: MessageDTO;
  userSender: User;
  userReciever:User;
  constructor(private route: ActivatedRoute, private messagingService:MessagingService, private userService: ProfileService ) {
    this.sendMess = new MessageDTO({
      senderUsername: '',
      recieverUsername: '',
      message: ''
    });
    this.userSender=new User({
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
    this.userReciever=new User({
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
    this.findUsers();
  }


  findUsers(){
    this.userService.getUser( this.route.snapshot.params['fid']).subscribe(res => this.userSender = res);
    this.userService.getUser(this.route.snapshot.params['id']).subscribe(res=> this.userReciever = res);
  }
  sendMessage(){
    console.log(this.userSender.username, this.userReciever.username);
    this.sendMess.senderUsername = this.userSender.username;
    this.sendMess.recieverUsername = this.userReciever.username;
    this.sendMess.message = this.msg;
    this.messagingService.sendMessage(this.sendMess).subscribe(res => this.retMes = res);
  }

}
