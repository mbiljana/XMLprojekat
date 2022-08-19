import {Component, Input, OnInit} from '@angular/core';
import {Message} from "../model/message";
import { ActivatedRoute } from '@angular/router';
import {MessagingService} from "../../service/messaging.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  @Input()
  messages:Message[];

  idLoginUser : any;


  constructor(private route: ActivatedRoute, private messagingService:MessagingService) {
  }

  ngOnInit(): void {
    this.loadMessages();
  }

  loadMessages(){
    this.idLoginUser = sessionStorage.getItem('id');
    console.log(this.idLoginUser);
    //this.messagingService.getAllMessages().subscribe(res=> this.messages=res);
    this.messagingService.getUserChat(this.idLoginUser).subscribe(res=> this.messages=res);


  }



}
