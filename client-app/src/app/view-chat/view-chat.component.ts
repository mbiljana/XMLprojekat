import {Component, Input, OnInit} from '@angular/core';
import {Message} from "../model/message";
import {ActivatedRoute} from "@angular/router";
import {MessagingService} from "../../service/messaging.service";
import {MessageDTO} from "../model/MessageDTO";

@Component({
  selector: 'app-view-chat',
  templateUrl: './view-chat.component.html',
  styleUrls: ['./view-chat.component.css']
})
export class ViewChatComponent implements OnInit {

  @Input()
  messages:Message[];
  msg:string;
  sendMsg: Message;
  messToSend: MessageDTO;
  chatWith:string;

  //prvo je sender, onda reciever
  sender: string;
  reciever: string;

  constructor(private route: ActivatedRoute, private messagingService:MessagingService) {
    this.messToSend = new MessageDTO({
      senderUsername: '',
      recieverUsername: '',
      message: ''
    });
  }

  ngOnInit(): void {
    this.loadMessages();
  }


  loadMessages(){
    this.sender = this.route.snapshot.params['id'];
    this.reciever = this.route.snapshot.params['fid'];
    this.messagingService.getMessagesWithUser(this.sender,this.reciever).subscribe(res=> this.messages=res);
    this.chatWith = this.route.snapshot.params['id'];
  }

  sendMessage(){
    this.messToSend.senderUsername = this.route.snapshot.params['fid'];
    this.messToSend.recieverUsername = this.route.snapshot.params['id'];
    this.messToSend.message = this.msg;
    this.messagingService.sendMessage(this.messToSend).subscribe(res => this.sendMsg = res);
  }

}
