import {Component, Input, OnInit} from '@angular/core';
import {MessageNotif} from "../model/message-notification";
import {ActivatedRoute} from "@angular/router";
import {ConnectionsService} from "../../service/connections.service";
import {ProfileService} from "../../service/profile.service";
import {NotificationService} from "../../service/notification.service";
import {Message} from "../model/message";
import {User} from "../model/user";

@Component({
  selector: 'tr[app-message-notif]',
  templateUrl: './message-notif.component.html',
  styleUrls: ['./message-notif.component.css']
})
export class MessageNotifComponent implements OnInit {


  @Input()
  public notif : MessageNotif;

  retNotif: MessageNotif;

  mess:Message;
  date:Date;
  user:User;

  constructor(private route: ActivatedRoute, private notifService: NotificationService, private profileService:ProfileService) {
    this.notif = new MessageNotif({
      id:0,
      message: this.mess,
      Date:this.date,
      user:this.user
    });
  }

  ngOnInit(): void {
    this.findNotif();
  }

  findNotif(){
    this.notifService.getOneNotification(this.notif.id).subscribe(res => this.retNotif = res);
  }

}
