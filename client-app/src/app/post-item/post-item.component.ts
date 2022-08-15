import { Post } from './../model/post';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'tr[app-post-item]',
  templateUrl: './post-item.component.html',
  styleUrls: ['./post-item.component.css']
})
export class PostItemComponent implements OnInit {
  @Input()
  post:Post;

  @Output()
  ClickedHolePostView:EventEmitter<Post>=new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }
  viewHolePost(){
    this.ClickedHolePostView.next(this.post);
    console.log(this.post);
  }

}
