import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { ProfileType } from '../model/profileType';
import { User } from '../model/user';

@Component({
  selector: 'tr[app-found-user]',
  templateUrl: './found-user.component.html',
  styleUrls: ['./found-user.component.css']
})
export class FoundUserComponent implements OnInit {
  @Input()
  public user:User;

  @Output()
  UserProfile: EventEmitter<User>=new EventEmitter();


  constructor() {
    this.user=new User({
      firstName: '',
      lastName: '',
      username: '',
      password: '',
      email: '',
      mobile: '',
      gender:'',
      profileType:ProfileType.Private,
      role:'',
      firstLogin:false
    });
  }

  ngOnInit(): void {
  }
  viewUserProfile(){
    this.UserProfile.next(this.user);
  }
}
