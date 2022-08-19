import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-make-new-post',
  templateUrl: './make-new-post.component.html',
  styleUrls: ['./make-new-post.component.css']
})
export class MakeNewPostComponent implements OnInit {
  selectedFile: File;
  makedPost:boolean=false;
  showMakePost:boolean=true;
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
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
  makeNewPost(){}
}
