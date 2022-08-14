import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {Message} from "../model/message";

@Component({
  selector: 'tr[app-user-messages]',
  templateUrl: './user-messages.component.html',
  styleUrls: ['./user-messages.component.css']
})
export class UserMessagesComponent implements OnInit {

  @Input()
  public mess: Message;

  constructor() {
    this.mess = new Message({
      senderUsername:'',
      recieverUsername:'',
      message: ''
    });
  }

  ngOnInit(): void {
  }

}
