import { UserLikePostDTO } from './../app/model/UserLikePostDTO';
import { Observable } from 'rxjs';
import { UserPost } from './../app/model/userPost';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserPostService {

  url = "http://localhost:8184/api/userPost";

  constructor(private http: HttpClient) { }

  save(newPost:UserPost):Observable<UserPost>{
    return this.http.post<UserPost>(this.url,newPost);
  }
  like(dto:UserLikePostDTO):Observable<UserPost>{
    return this.http.post<UserPost>(this.url+"/like",dto);
  }
  dislike(dto:UserLikePostDTO):Observable<UserPost>{
    return this.http.post<UserPost>(this.url+"/dislike",dto);
  }
  searchPostByUser(id:number):Observable<UserPost[]>{
    return this.http.get<UserPost[]>(`${this.url+"/user"}/${id}`);
  }
  getUserPost(id:number):Observable<UserPost>{
    return this.http.get<UserPost>(`${this.url}/${id}`);
  }
  getUserPostFromFollowing(id:number):Observable<UserPost[]>{
    return this.http.get<UserPost[]>(`${this.url+"/following"}/${id}`);
  }
}
