import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post } from 'src/app/model/post';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  url = "http://localhost:8083/api/post";
  constructor(private http: HttpClient) { }

  save(newPost:Post):Observable<Post>{
    return this.http.post<Post>(this.url,newPost);
  }
}
