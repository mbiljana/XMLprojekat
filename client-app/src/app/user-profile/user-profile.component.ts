import { ProfileService } from './../../service/profile.service';
import { ProfileType } from './../model/profileType';
import { User } from 'src/app/model/user';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  @Input()
  user:User;

  id:number;
  compare=ProfileType.Private;

  showAllInformation:boolean=false;

  constructor(private route: ActivatedRoute,private profileService: ProfileService) {
    this.user=new User({
      firstName: '',
      lastName: '',
      username: '',
      password: '',
      email: '',
      mobile: '',
      gender:'',
      profileType:ProfileType.Private
    });
  }

  ngOnInit(): void {
    this.loadClient();

  }
  loadClient(){
    this.id = this.route.snapshot.params['id'];
    this.profileService.getUser(this.id)
      .subscribe(res =>{
        this.user = res;
        console.log(res.profileType)
        if(res.profileType.valueOf()===ProfileType.Private.valueOf()){
          this.showAllInformation=false;
        }else{
          this.showAllInformation=true;
        }
      }
      )
  }
  checkProfileType(){
    if(this.user.profileType==ProfileType.Private){
      this.showAllInformation=false;
    }else{
      this.showAllInformation=true;
    }
  }
}
