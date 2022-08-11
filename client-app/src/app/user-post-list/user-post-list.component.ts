import { Component, Input, OnInit } from '@angular/core';
import { UserPost } from '../model/userPost';

@Component({
  selector: 'app-user-post-list',
  templateUrl: './user-post-list.component.html',
  styleUrls: ['./user-post-list.component.css']
})
export class UserPostListComponent implements OnInit {

  @Input()
  posts:UserPost[];
  constructor() { }

  ngOnInit(): void {
  }

}
