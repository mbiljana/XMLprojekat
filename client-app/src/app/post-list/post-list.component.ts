import { PostService } from './../../service/post.service';
import { Post } from './../model/post';
import { Component, Input, OnInit } from '@angular/core';


@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {
  @Input()
  posts:Post[];
  constructor() {
    this.posts=[];
   }

  ngOnInit(): void {
  }

}
