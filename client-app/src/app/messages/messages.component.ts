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

  constructor(private route: ActivatedRoute, private messagingService:MessagingService) {
  }

  ngOnInit(): void {
    this.loadMessages();
  }

  loadMessages(){
    this.messagingService.getAllMessages().subscribe(res=> this.messages=res);
  }



}
