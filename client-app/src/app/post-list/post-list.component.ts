import { PostService } from './../../service/post.service';
import { Post } from './../model/post';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';


@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {
  @Input()
  posts:Post[];
  @Output()
  ClickedHolePostView:EventEmitter<Post>=new EventEmitter();
  constructor() {
    this.posts=[];
   }

  ngOnInit(): void {
  }
  showHolePostProfile(post:Post){
    this.ClickedHolePostView.next(post);
    console.log(post);
  }
}
