import {Component, Input, OnInit} from '@angular/core';
import {MessageNotif} from "../model/message-notification";
import {Message} from "../model/message";
import {User} from "../model/user";
import {ActivatedRoute} from "@angular/router";
import {NotificationService} from "../../service/notification.service";
import {ProfileService} from "../../service/profile.service";

@Component({
  selector: 'tr[app-post-notif]',
  templateUrl: './post-notif.component.html',
  styleUrls: ['./post-notif.component.css']
})
export class PostNotifComponent implements OnInit {

  @Input()
  public notif : MessageNotif;

  retNotif: MessageNotif;
  sender: string;

  mess:Message;
  date:Date;
  user:User;
  isPost:boolean;

  constructor(private route: ActivatedRoute, private notifService: NotificationService, private profileService:ProfileService) {
    this.notif = new MessageNotif({
      id:0,
      message: new Message({
        id:0,
        senderUsername:'',
        recieverUsername:'',
        message:'',
        sentDate:this.date
      }),
      Date:this.date,
      user:'',
      post:false
    });
    this.retNotif = new MessageNotif({
      id:0,
      message: new Message({
        id:0,
        senderUsername:'',
        recieverUsername:'',
        message:'',
        sentDate:this.date
      }),
      Date:this.date,
      user:'',
      post:false
    });
    this.sender = '';
  }

  ngOnInit(): void {
    this.findNotif();
    console.log(this.notif.id);
  }

  findNotif(){
    this.notifService.getOneNotification(this.notif.id).subscribe(res => {
      this.notif = res;
    });
  }


}
