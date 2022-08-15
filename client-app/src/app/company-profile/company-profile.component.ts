import { PostService } from './../../service/post.service';
import { Post } from './../model/post';
import { Company } from './../model/company';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-company-profile',
  templateUrl: './company-profile.component.html',
  styleUrls: ['./company-profile.component.css']
})
export class CompanyProfileComponent implements OnInit {
  @Input()
  company:Company;

  selectedPost:Post;

  showPost=false;
  showHolePost=false;

  posts:Post[];
  constructor(private postService:PostService) {
    this.posts=[];
    console.log(this.company)
   }

  ngOnInit(): void {
  }

  public showPosts(){
    this.postService.searchPostByCompany(this.company.id)
    .subscribe(res=>this.posts=res);
    this.showPost=true;
  }
  showHolePostProfile(post:Post){
    this.showHolePost=true;
    this.showPost=false;
    this.selectedPost=post;
  }
  showAllPosts(){
    this.showPost=true;
    this.showHolePost=false;
  }
}
