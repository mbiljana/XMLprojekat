import { PopUpLoginComponent } from './../pop-up-login/pop-up-login.component';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { UserLikePostDTO } from './../model/UserLikePostDTO';
import { ActivatedRoute, Router } from '@angular/router';
import { CommentService } from './../../service/comment.service';
import { UserPostService } from './../../service/user-post.service';
import { ProfileType } from './../model/profileType';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { UserPost } from '../model/userPost';
import { User } from '../model/user';
import { Comment } from '../model/comment';
import { ProfileService } from 'src/service/profile.service';


@Component({
  selector: 'app-user-post-profile',
  templateUrl: './user-post-profile.component.html',
  styleUrls: ['./user-post-profile.component.css']
})


export class UserPostProfileComponent implements OnInit {
  @Input()
  post:UserPost;
  @Input()
  id:number;

  @Input()
  typeComponent:string;

  comments:Comment[]

  idLoginUser:any;

  dto:UserLikePostDTO;


  @Output()
  ClickedBAckToAllPosts:EventEmitter<void>=new EventEmitter();

  constructor(private dialogRef: MatDialog,private route: ActivatedRoute,private userPostService:UserPostService,private profileService: ProfileService, private commentService:CommentService,private router: Router) {

    this.dto=new UserLikePostDTO({
      userId:0,
      userPost:new UserPost({

        user:new User({
          id:0,
          firstName: '',
          lastName: '',
          username: '',
          password: '',
          email: '',
          mobile: '',
          gender:'',
          profileType:ProfileType.Private,
          role:'',
          firstLogin:false
        }),
        id:0,
        text:'',
        links:[],
        picture:'',
        likes:0,
        dislikes:0,
        userWhoLiked:[]
      })
    })

  }

  ngOnInit(): void {
    this.loadUser();
    this.loadComments();
  }
  loadUser(){
    this.idLoginUser = sessionStorage.getItem('id');
    console.log(this.idLoginUser)
    this.profileService.getUser(this.idLoginUser)
    .subscribe(res =>
      this.dto.userId = res.id
    )
}
  loadComments(){
    this.commentService.searchCommentByUserPost(this.id)
    .subscribe(res=>this.comments=res)
  }

  backToProfile(){
    this.ClickedBAckToAllPosts.next();
  }
  likePost(){
    this.dto.userPost=this.post;
    this.userPostService.like(this.dto)
    .subscribe(res=>{
      if(res==null){
        this.dialogRef.open(PopUpLoginComponent)
      }else{
        this.post=res
      }
    });
  }
  dislikePost(){
    this.post.dislikes=this.post.dislikes+1;
    this.userPostService.save(this.post)
    .subscribe(res=>this.post=res);
  }
  addCom(){
    console.log(this.typeComponent)
    if(this.typeComponent=="userPersonalProfile"){
      var link1="search"+this.post.user.id+"/newComment"
      this.router.navigate(['link1']);
    }else{
      this.router.navigate(['/search']);
    }
  }
}
