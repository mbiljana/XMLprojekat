import { UserPostService } from 'src/service/user-post.service';
import { UserPost } from './../model/userPost';
import { Component, OnInit } from '@angular/core';
import { ProfileService } from 'src/service/profile.service';

@Component({
  selector: 'app-all-post-from-following',
  templateUrl: './all-post-from-following.component.html',
  styleUrls: ['./all-post-from-following.component.css']
})
export class AllPostFromFollowingComponent implements OnInit {

  posts:UserPost[];
  idLoginUser:any;
  constructor(private userPostService: UserPostService,private profileService: ProfileService) {
    this.posts=[];
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

}
