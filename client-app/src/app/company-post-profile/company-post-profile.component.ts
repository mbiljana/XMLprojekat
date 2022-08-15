import { Component, Input, OnInit } from '@angular/core';
import { CommentService } from 'src/service/comment.service';
import { Comment } from '../model/comment';
import { Post } from '../model/post';

@Component({
  selector: 'app-company-post-profile',
  templateUrl: './company-post-profile.component.html',
  styleUrls: ['./company-post-profile.component.css']
})
export class CompanyPostProfileComponent implements OnInit {
  @Input()
  post:Post;

  @Input()
  id:number;

  comments:Comment[]
  constructor(private commentService:CommentService) { }

  ngOnInit(): void {
    this.loadComments();
  }
  likePost(){
    this.post.numOfLikes=this.post.numOfLikes+1;
   // this.userPostService.save(this.post)
    //.subscribe(res=>this.post=res);
  }
  dislikePost(){
    this.post.numOfDislikes=this.post.numOfDislikes+1;
    //this.userPostService.save(this.post)
    //.subscribe(res=>this.post=res);
  }
  backToProfile(){}
  loadComments(){
    this.commentService.searchCommentByUserPost(this.id)
    .subscribe(res=>this.comments=res)
  }
}
