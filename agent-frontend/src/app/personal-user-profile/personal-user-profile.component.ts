import { UserService } from './../../service/user.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../model/user';

@Component({
  selector: 'app-personal-user-profile',
  templateUrl: './personal-user-profile.component.html',
  styleUrls: ['./personal-user-profile.component.css']
})
export class PersonalUserProfileComponent implements OnInit {
  user:User;
  userId:number;
  constructor(private userService : UserService,private router: Router,private route: ActivatedRoute) {
    this.user=new User({
      id:0,
      firstName: '',
      lastName: '',
      username: '',
      password: '',
      email: '',
      mobile: '',
      gender:'',
      role:'',
      firstLogin:false
    })
   }

  ngOnInit(): void {
    this.loadUser()
  }

  loadUser(){
    this.userId = this.route.snapshot.params['id'];
    this.userService.getUser(this.userId)
    .subscribe(res =>
      this.user= res
    )
  }
}
