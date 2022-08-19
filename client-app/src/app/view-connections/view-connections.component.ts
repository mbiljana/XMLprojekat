import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ProfileService} from "../../service/profile.service";
import {ConnectionsService} from "../../service/connections.service";
import {User} from "../model/user";

@Component({
  selector: 'app-view-connections',
  templateUrl: './view-connections.component.html',
  styleUrls: ['./view-connections.component.css']
})
export class ViewConnectionsComponent implements OnInit {

  id:number;
  loggedUser: User;

  @Input()
  connections : string[];

  constructor(private route: ActivatedRoute, private profileService: ProfileService, private connectionService:ConnectionsService) { }

  ngOnInit(): void {
    this.loadUser();
  }

  loadUser(){
    this.id = this.route.snapshot.params['id'];
    //this.idLoginUser = sessionStorage.getItem('id');
    this.profileService.getUser(this.id)
      .subscribe(res =>{
          this.loggedUser = res;
          this.connectionService.getUsersConnections(this.id).subscribe(res=> this.connections=res);
        }

      )
    //console.log(this.id);
  }

}
