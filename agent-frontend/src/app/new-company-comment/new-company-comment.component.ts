import { CompanyService } from 'src/service/company.service';
import { User } from './../model/user';
import { CommentService } from './../../service/comment.service';
import { UserService } from './../../service/user.service';
import { Component, OnInit } from '@angular/core';
import { Comment } from '../model/comment';
import { Company } from '../model/company';
import { Address } from '../model/address';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-new-company-comment',
  templateUrl: './new-company-comment.component.html',
  styleUrls: ['./new-company-comment.component.css']
})
export class NewCompanyCommentComponent implements OnInit {
  newComment:Comment;
  makedPost:boolean=false;
  showMakePost:boolean=true;
  idLoginUser:any;
  companyId:number;
  constructor(private userService:UserService,
              private commentService:CommentService,
              private router: Router,
              private route: ActivatedRoute,
              private companyService:CompanyService) {
this.newComment=new Comment({
  id:0,
  text:'',
  user:new User({
    id:0,
    firstName: '',
    lastName: '',
    username: '',
    password: '',
    email: '',
    mobile: '',
    gender:'',
    role:'',
    firstLogin:false
  }),
  company:new Company({
    grades:[],
    salaries:[],
    id:0,
    name:'',
    description:'',
    address:new Address({
      city:'',
      state:'',
      street:''
    }),
    username:'',
    email:'',
    mobile:'',
    profilePicture:'',
    owner:new User({
      id:0,
      firstName: '',
      lastName: '',
      username: '',
      password: '',
      email: '',
      mobile: '',
      gender:'',
      role:'',
      firstLogin:false
    })
  })
})
              }

  ngOnInit(): void {
    this.loadUser();
    this.loadCompany();
  }
  loadUser(){
    this.idLoginUser = sessionStorage.getItem('id');
    console.log(this.idLoginUser)
    this.userService.getUser(this.idLoginUser)
    .subscribe(res =>
      this.newComment.user = res
    )
}
  makeNewComment(){
    this.commentService.save(this.newComment)
    .subscribe()
    this.makedPost=true;
    this.showMakePost=false;
  }
  backToAllPost(){
    this.router.navigate(['company',this.newComment.company.id]);
  }
  loadCompany(){

    this.companyId = this.route.snapshot.params['id'];
    this.companyService.getOneById(this.companyId)
    .subscribe(res=>this.newComment.company=res)
  }
}
