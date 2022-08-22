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
  role:any;
  visable_owner_button:boolean=false;
  visable_admin_button:boolean=false;
  visable_user_button:boolean=false;
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
    this.role = sessionStorage.getItem('role');
    if (this.role == 'Owner') {
      this.visable_owner_button=true;

    }
    if (this.role == 'Admin') {
      this.visable_admin_button=true;

    }
    if (this.role == 'User') {
      this.visable_user_button=true;

    }
    this.userId = this.route.snapshot.params['id'];
    this.userService.getUser(this.userId)
    .subscribe(res =>
      this.user= res
    )
  }
}
