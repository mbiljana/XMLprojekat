import { Component, OnInit } from '@angular/core';
import {Message} from "../model/message";
import {MessageDTO} from "../model/MessageDTO";
import {ActivatedRoute} from "@angular/router";
import {MessagingService} from "../../service/messaging.service";

@Component({
  selector: 'app-send-message',
  templateUrl: './send-message.component.html',
  styleUrls: ['./send-message.component.css']
})
export class SendMessageComponent implements OnInit {

  msg:string;
  retMes: Message;
  sendMess: MessageDTO;
  constructor(private route: ActivatedRoute, private messagingService:MessagingService) {
    this.sendMess = new MessageDTO({
      senderUsername: '',
      recieverUsername: '',
      message: ''
    });
  }

  ngOnInit(): void {
  }

  sendMessage(){
    this.sendMess.senderUsername = this.route.snapshot.params['fid'];
    this.sendMess.recieverUsername = this.route.snapshot.params['id'];
    this.sendMess.message = this.msg;
    this.messagingService.sendMessage(this.sendMess).subscribe(res => this.retMes = res);
  }

}
