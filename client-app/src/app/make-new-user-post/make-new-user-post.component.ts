import { ActivatedRoute } from '@angular/router';
import { ProfileService } from './../../service/profile.service';
import { ProfileType } from './../model/profileType';
import { UserPost } from './../model/userPost';
import { UserPostService } from './../../service/user-post.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';

@Component({
  selector: 'app-make-new-user-post',
  templateUrl: './make-new-user-post.component.html',
  styleUrls: ['./make-new-user-post.component.css']
})
export class MakeNewUserPostComponent implements OnInit {
  text:string;
  links_text:string;
  selectedFile: File;
  userPost:UserPost;
  id:number;
  constructor(private http: HttpClient,private userPostService:UserPostService,
    private route: ActivatedRoute,private profileService: ProfileService) {

    this.userPost=new UserPost({

      user:new User({
        firstName: '',
        lastName: '',
        username: '',
        password: '',
        email: '',
        mobile: '',
        gender:'',
        profileType:ProfileType.Private
      }),
      text:'',
      links:[],
      picture:''
    });
   }

  ngOnInit(): void {
    this.loadClient();
  }
  loadClient(){
    console.log(this.id);
    this.id = this.route.snapshot.params['id'];
    this.profileService.getUser(this.id)
      .subscribe(res =>
        this.userPost.user = res
      )
  }
  public onFileChanged(event: any) {
    this.selectedFile = event.target.files[0];
  }
  onUpload() {
    console.log(this.selectedFile);

    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();
    uploadImageData.append('file', this.selectedFile, this.selectedFile.name);
    this.http.post('http://localhost:8080/upload', uploadImageData)
      .subscribe((response) => {

      }
      );
  }
  makeNewPost(){
    var list_links=this.links_text.split(" ");
    var path_picture="/assets/userPostPicture/"+this.selectedFile.name;

    this.userPost.text=this.text;
    this.userPost.links=list_links;
    this.userPost.picture=path_picture;
    this.userPostService.save(this.userPost)
    .subscribe()
  }
}
