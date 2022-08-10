import { Observable } from 'rxjs';
import { UserPost } from './../app/model/userPost';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserPostService {

  url = "http://localhost:8080/api/userPost";

  constructor(private http: HttpClient) { }

  save(newPost:UserPost):Observable<UserPost>{
    return this.http.post<UserPost>(this.url,newPost);
  }

}
