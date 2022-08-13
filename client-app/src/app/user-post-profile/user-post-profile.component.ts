import { ActivatedRoute } from '@angular/router';
import { CommentService } from './../../service/comment.service';
import { UserPostService } from './../../service/user-post.service';
import { ProfileType } from './../model/profileType';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { UserPost } from '../model/userPost';
import { User } from '../model/user';
import { Comment } from '../model/comment';

@Component({
  selector: 'app-user-post-profile',
  templateUrl: './user-post-profile.component.html',
  styleUrls: ['./user-post-profile.component.css']
})
export class UserPostProfileComponent implements OnInit {
  @Input()
  post:UserPost;
  @Input()
  id:number;

  comments:Comment[]




  @Output()
  ClickedBAckToAllPosts:EventEmitter<void>=new EventEmitter();

  constructor(private route: ActivatedRoute,private userPostService:UserPostService, private commentService:CommentService) {


  }

  ngOnInit(): void {
    this.loadComments();
  }
  loadComments(){
    this.commentService.searchCommentByUserPost(this.id)
    .subscribe(res=>this.comments=res)
  }

  backToProfile(){
    this.ClickedBAckToAllPosts.next();
  }
  likePost(){
    this.post.likes=this.post.likes+1;
    this.userPostService.save(this.post)
    .subscribe(res=>this.post=res);
  }
  dislikePost(){
    this.post.dislikes=this.post.dislikes+1;
    this.userPostService.save(this.post)
    .subscribe(res=>this.post=res);
  }

}
