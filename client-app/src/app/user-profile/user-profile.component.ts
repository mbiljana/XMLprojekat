import { ProgramLanguage } from './../model/programLanguage';
import { ProfileService } from './../../service/profile.service';
import { ProfileType } from './../model/profileType';
import { User } from 'src/app/model/user';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Profile } from '../model/profile';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {


  user:User;

  profile:Profile;


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
    this.profile=new Profile({
      user:new User({
        firstName: '',
        lastName: '',
        username: '',
        password: '',
        email: '',
        mobile: '',
        gender:'',
        profileType:ProfileType.Private
      }),
      proramLanguages:[],
      exCompanies:[],
      languages:[],
      education:'',
      additionInformation:'',
      profileType:ProfileType.Private
    });
  }

  ngOnInit(): void {
    this.loadProfile();
  }

  loadClient(){
    console.log(this.id);
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
  loadProfile(){
    this.id = this.route.snapshot.params['id'];
    this.profileService.getProfile(this.id)
      .subscribe(res=>this.profile=res)
  }
  checkProfileType(){
    if(this.user.profileType==ProfileType.Private){
      this.showAllInformation=false;
    }else{
      this.showAllInformation=true;
    }
  }

  followUser() {
    this.profileService.followUser(this.user.username, this.user.username);
  }
}
