import {Component, Input, OnInit} from '@angular/core';
import {User} from "../model/user";
import {MessageNotif} from "../model/message-notification";
import {ActivatedRoute} from "@angular/router";
import {ProfileService} from "../../service/profile.service";
import {NotificationService} from "../../service/notification.service";

@Component({
  selector: 'app-post-notifs',
  templateUrl: './post-notifs.component.html',
  styleUrls: ['./post-notifs.component.css']
})
export class PostNotifsComponent implements OnInit {

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
          this.notifService.getPostNotifications(this.id).subscribe(res=> this.notifications=res);
        }
      )

  }


}
