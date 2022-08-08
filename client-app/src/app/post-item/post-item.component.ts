import { Post } from './../model/post';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'tr[app-post-item]',
  templateUrl: './post-item.component.html',
  styleUrls: ['./post-item.component.css']
})
export class PostItemComponent implements OnInit {
  @Input()
  post:Post;
  constructor() { }

  ngOnInit(): void {
  }
  viewComment(){}

}