import {Component, Input, OnInit} from '@angular/core';
import {PostService} from "../../service/post.service";
import {SearchJObDTO} from "../model/SearchJobDTO";
import {Post} from "../model/post";

@Component({
  selector: 'app-search-job',
  templateUrl: './search-job.component.html',
  styleUrls: ['./search-job.component.css']
})
export class SearchJobComponent implements OnInit {

  @Input()
  title:string;
  res: SearchJObDTO;
  posts:Post[];
  constructor(private postService:PostService) {
    this.res = new SearchJObDTO({
      title:''
    });
  }

  ngOnInit(): void {
  }

  searchJob(){
    this.res.title = this.title;
    this.postService.searchJobs(this.res).subscribe(res => this.posts = res);
  }



}
