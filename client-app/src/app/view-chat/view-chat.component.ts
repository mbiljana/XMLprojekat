import {Component, Input, OnInit} from '@angular/core';
import {Message} from "../model/message";
import {ActivatedRoute} from "@angular/router";
import {MessagingService} from "../../service/messaging.service";

@Component({
  selector: 'app-view-chat',
  templateUrl: './view-chat.component.html',
  styleUrls: ['./view-chat.component.css']
})
export class ViewChatComponent implements OnInit {

  @Input()
  messages:Message[];
  //prvo je sender, onda reciever
  sender: string;
  reciever: string;

  constructor(private route: ActivatedRoute, private messagingService:MessagingService) {
  }

  ngOnInit(): void {
    this.loadMessages();
  }


  loadMessages(){
    this.sender = this.route.snapshot.params['id'];
    this.reciever = this.route.snapshot.params['fid'];
    this.messagingService.getMessagesWithUser(this.sender,this.reciever).subscribe(res=> this.messages=res);
  }

}
