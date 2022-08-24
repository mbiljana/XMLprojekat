import { PostService } from './../../service/post.service';
import { Post } from './../model/post';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Company } from '../model/company';
import { Address } from '../model/address';
import { User } from '../model/user';
import { CompanyService } from 'src/service/company.service';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-make-new-post',
  templateUrl: './make-new-post.component.html',
  styleUrls: ['./make-new-post.component.css']
})
export class MakeNewPostComponent implements OnInit {
  selectedFile: File;
  makedPost:boolean=false;
  showMakePost:boolean=true;
  listOfPreconditions:string[];
  onePrecondition:string;
  newPost:Post;
  userId:any;
  constructor(private http: HttpClient,private companyService:CompanyService,private route: ActivatedRoute,private postService:PostService) {
    this.listOfPreconditions=[];
    this.newPost=new Post({
      id: 0,
      company:new Company({
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
        }),
      title:'',
      jobDescription:'',
      preconditions:[],
      position:'',
      picture:'',
      numOfLikes:0,
      numOfDislikes:0
    })
  }

  ngOnInit(): void {
    this.loadCompany();
  }
  public onFileChanged(event: any) {
    this.selectedFile = event.target.files[0];

  }
  onUpload() {
    console.log(this.selectedFile);

    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();
    uploadImageData.append('file', this.selectedFile, this.selectedFile.name);
    this.http.post('http://localhost:8083/upload', uploadImageData)
      .subscribe((response) => {

      }
      );
  }
  makeNewPost(){
    this.newPost.preconditions=this.listOfPreconditions;
    var path_picture="/assets/postPicture/"+this.selectedFile.name;
    this.newPost.picture=path_picture;
    console.log(this.newPost)
    this.postService.save(this.newPost)
    .subscribe()
    this.makedPost=true;
  }
  loadCompany(){
    this.userId = this.route.snapshot.params['id'];
    this.companyService.getOneByOwnerId(this.userId)
    .subscribe(res=>this.newPost.company=res)
  }
  addNewPrecondition(){
    this.listOfPreconditions.push(this.onePrecondition);
    console.log(this.listOfPreconditions)
  }
}
