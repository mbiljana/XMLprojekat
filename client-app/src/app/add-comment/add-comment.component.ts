
import { Component, OnInit } from '@angular/core';
import { UserPostService } from './../../service/user-post.service';
import { HttpClient } from '@angular/common/http';
import { CommentService } from 'src/service/comment.service';
import { ProfileService } from 'src/service/profile.service';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../model/user';
import { ProfileType } from '../model/profileType';
import { UserPost } from '../model/userPost';
import { Comment } from '../model/comment';

@Component({
  selector: 'app-add-comment',
  templateUrl: './add-comment.component.html',
  styleUrls: ['./add-comment.component.css']
})
export class AddCommentComponent implements OnInit {
  newComment:Comment;
  postId:number;
  id:number;
  text:string;
  makedPost:boolean=false;
  showMakePost:boolean=true;
  idLoginUser:any;
  constructor(private http: HttpClient,private userPostService:UserPostService,private route: ActivatedRoute,
    private commentService:CommentService,private router: Router,
    private profileService: ProfileService) {
      this.newComment=new Comment({

        user:new User({
          firstName: '',
          lastName: '',
          username: '',
          password: '',
          email: '',
          mobile: '',
          gender:'',
          profileType:ProfileType.Private,
          firstLogin:false,
          role:''
        }),

        id:0,
        text:''
      });

  }

  ngOnInit(): void {
    this.loadPost();
    this.loadUser();
  }

  loadPost(){

    this.postId = this.route.snapshot.params['postId'];
    this.userPostService.getUserPost(this.postId)
      .subscribe(res =>{
        this.newComment.userPost = res
        console.log(res);}
      )
  }
  loadUser(){
      this.idLoginUser = sessionStorage.getItem('id');
      console.log(this.idLoginUser)
      this.profileService.getUser(this.idLoginUser)
      .subscribe(res =>
        this.newComment.user = res
      )
  }
  makeNewComment(){

    this.newComment.text=this.text;
    console.log(this.newComment)
    this.commentService.save(this.newComment)
    .subscribe()
    this.makedPost=true;
    this.showMakePost=false;
  }
  backToProfile(){
    this.router.navigate(['profile',this.idLoginUser]);
  }
}
