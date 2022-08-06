import { User } from './../model/user';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-found-users',
  templateUrl: './found-users.component.html',
  styleUrls: ['./found-users.component.css']
})
export class FoundUsersComponent implements OnInit {

  @Input()
  users:User[];

  constructor() {
    this.users=[];
  }


  ngOnInit(): void {
  }

}
