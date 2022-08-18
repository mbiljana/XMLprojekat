import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-new-company-request',
  templateUrl: './new-company-request.component.html',
  styleUrls: ['./new-company-request.component.css']
})
export class NewCompanyRequestComponent implements OnInit {
  makedCompany:boolean=false;
  showMakeCompany:boolean=true;
  selectedFile: File;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }
  sendRequsest(){}
  backToProfile(){}

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

  public onFileChanged(event: any) {
    this.selectedFile = event.target.files[0];
  }
}
