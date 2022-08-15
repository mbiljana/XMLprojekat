import { Component, Input, OnInit, EventEmitter, Output } from '@angular/core';
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

  @Output()
  ClickBackToCompanyProfile:EventEmitter  <void> = new EventEmitter();

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
  backToProfile(){
    this.ClickBackToCompanyProfile.next();
  }
  loadComments(){
    this.commentService.searchCommentByCompanyPost(this.id)
    .subscribe(res=>this.comments=res)
  }
}
