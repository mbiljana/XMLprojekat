import {Component, Input, OnInit} from '@angular/core';
import {Message} from "../model/message";

@Component({
  selector: 'tr[app-view-chat-oneline]',
  templateUrl: './view-chat-oneline.component.html',
  styleUrls: ['./view-chat-oneline.component.css']
})
export class ViewChatOnelineComponent implements OnInit {


  @Input()
  public mess: Message;
  private date:Date;

  constructor() {
    this.mess = new Message({
      senderUsername:'',
      recieverUsername:'',
      message: '',
      sentDate: this.date
    });
  }

  ngOnInit(): void {
  }

}
