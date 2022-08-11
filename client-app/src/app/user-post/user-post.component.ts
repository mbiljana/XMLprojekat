import { ProfileType } from './../model/profileType';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { User } from '../model/user';
import { UserPost } from '../model/userPost';

@Component({
  selector: 'tr[app-user-post]',
  templateUrl: './user-post.component.html',
  styleUrls: ['./user-post.component.css']
})
export class UserPostComponent implements OnInit {
  @Input()
  post:UserPost;

  @Output()
  ClickedHolePostView:EventEmitter<UserPost>=new EventEmitter();

  constructor() {

   }

  ngOnInit(): void {
  }
  viewHolePost(){
    this.ClickedHolePostView.next(this.post);
    console.log(this.post);
  }
}
