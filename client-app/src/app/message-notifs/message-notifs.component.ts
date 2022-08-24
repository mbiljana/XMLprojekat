import {Component, Input, OnInit} from '@angular/core';
import {User} from "../model/user";
import {MessageNotif} from "../model/message-notification";
import {ActivatedRoute} from "@angular/router";
import {ProfileService} from "../../service/profile.service";
import {NotificationService} from "../../service/notification.service";

@Component({
  selector: 'app-message-notifs',
  templateUrl: './message-notifs.component.html',
  styleUrls: ['./message-notifs.component.css']
})
export class MessageNotifsComponent implements OnInit {

  id:any;
  loggedUser: User;

  @Input()
  notifications : MessageNotif[];

  constructor(private route: ActivatedRoute, private profileService: ProfileService, private notifService: NotificationService) { }

  ngOnInit(): void {
    this.loadNotifs();
  }

  loadNotifs(){
    this.id = sessionStorage.getItem('id');
    this.profileService.getUser(this.id)
      .subscribe(res =>{
          this.loggedUser = res;
          this.notifService.getMessageNotifications(this.id).subscribe(res=> this.notifications=res);
        }
      )

  }

}
