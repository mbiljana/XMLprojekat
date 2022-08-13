import { CommentService } from './../../service/comment.service';
import { UserPostService } from './../../service/user-post.service';
import { UserPost } from './../model/userPost';
import { ProfileType } from './../model/profileType';
import { Profile } from './../model/profile';
import { ActivatedRoute } from '@angular/router';
import { ProfileService } from './../../service/profile.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { ThisReceiver } from '@angular/compiler';

@Component({
  selector: 'app-user-personal-profile',
  templateUrl: './user-personal-profile.component.html',
  styleUrls: ['./user-personal-profile.component.css']
})
export class UserPersonalProfileComponent implements OnInit {

  profile:Profile;
  id:number;
  posts:UserPost[];
  post:UserPost;
  showUserPosts:boolean=true;
  showHolePost:boolean=false;

  constructor(private route: ActivatedRoute,private profileService: ProfileService,private userPostService: UserPostService,private commentService:CommentService) {
    this.posts=[]
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
  loadProfile(){
    this.id = this.route.snapshot.params['id'];
    this.profileService.getProfile(this.id)
      .subscribe(res=>{
        this.profile=res;
        this.userPostService.searchPostByUser(this.id)
        .subscribe(res=>this.posts=res)
      })
  }
  viewHolePost(post:UserPost){
    this.showHolePost=true;
    this.post=post;
    console.log(post)
    this.showUserPosts=false;
  }
  showAllPosts(){
    this.loadProfile();
    this.showUserPosts=true;
    this.showHolePost=false;
  }
}
