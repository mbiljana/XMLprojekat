import {Component, Input, OnInit} from '@angular/core';
import {Post} from "../model/post";
import {ActivatedRoute} from "@angular/router";
import {PostService} from "../../service/post.service";
import {Company} from "../model/company";

@Component({
  selector: 'tr[app-search-job-view]',
  templateUrl: './search-job-view.component.html',
  styleUrls: ['./search-job-view.component.css']
})
export class SearchJobViewComponent implements OnInit {


  @Input()
  public post : Post;

  retPost:Post;
  public company:Company;

  constructor(private route: ActivatedRoute, private postService:PostService) {
    this.post = new Post({
      id:0,
      title: '',
      jobDescription: '',
      picture: '',
      preconditions: [],
      position:'',
      numOfLikes: 0,
      numOfDislikes: 0,
      company: this.company
    });
  }

  ngOnInit(): void {
    this.findPost();
  }


  findPost(){
    this.postService.searchPost(this.post.id).subscribe(res => this.retPost = res);
  }
}
