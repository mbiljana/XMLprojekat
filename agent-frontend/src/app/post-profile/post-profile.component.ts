import { PostService } from './../../service/post.service';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Post } from '../model/post';

@Component({
  selector: 'app-post-profile',
  templateUrl: './post-profile.component.html',
  styleUrls: ['./post-profile.component.css']
})
export class PostProfileComponent implements OnInit {
  post:Post;
  comments:Comment[];
  postId:number;
  @Output()
  ClickBackToCompanyProfile:EventEmitter  <void> = new EventEmitter();
  constructor(private route: ActivatedRoute,private postService:PostService) { }

  ngOnInit(): void {
    this.loadPost();
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
    //this.commentService.searchCommentByCompanyPost(this.id)
    //.subscribe(res=>this.comments=res)
  }
  loadPost(){
    this.postId = this.route.snapshot.params['postId'];
    this.postService.getOneById(this.postId)
    .subscribe(res=>this.post=res)
  }
}
