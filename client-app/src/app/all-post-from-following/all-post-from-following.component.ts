import { ProfileType } from './../model/profileType';
import { UserPostService } from 'src/service/user-post.service';
import { UserPost } from './../model/userPost';
import { Component, OnInit } from '@angular/core';
import { ProfileService } from 'src/service/profile.service';
import { User } from '../model/user';

@Component({
  selector: 'app-all-post-from-following',
  templateUrl: './all-post-from-following.component.html',
  styleUrls: ['./all-post-from-following.component.css']
})
export class AllPostFromFollowingComponent implements OnInit {

  posts:UserPost[];
  userPost:UserPost;
  idLoginUser:any;
  showHolePost:boolean=false;
  ShowAllPostsPage:boolean=true;
  constructor(private userPostService: UserPostService,private profileService: ProfileService) {
    this.posts=[];
    this.userPost=new UserPost({

      user:new User({
        id:0,
        firstName: '',
        lastName: '',
        username: '',
        password: '',
        email: '',
        mobile: '',
        gender:'',
        profileType:ProfileType.Private,
        role:'',
        firstLogin:false,
        following:[],
        followRequests:[]
      }),
      id:0,
      text:'',
      links:[],
      picture:'',
      likes:0,
      dislikes:0,
      userWhoLiked:[]
    });

  }

  ngOnInit(): void {
    this.loadUser();
  }
  loadUser(){
    this.idLoginUser = sessionStorage.getItem('id');
    this.profileService.getUser(this.idLoginUser)
    .subscribe(res =>
      this.userPostService.getUserPostFromFollowing(res.id)
      .subscribe(res1=>this.posts=res1)
    )
}
viewDetatails(current:UserPost){
  this.userPost=current;
  this.showHolePost=true;
  this.ShowAllPostsPage=false;
}
  showAllPosts(){
    this.ShowAllPostsPage=true;
    this.showHolePost=false;
  }
}
