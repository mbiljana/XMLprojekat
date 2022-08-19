import { Comment } from './../app/model/comment';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  url = "http://localhost:8184/api/comment";
  urlCompanyPost = "http://localhost:8184/api/comment/companyPost";

  constructor(private http: HttpClient) { }

  searchCommentByUserPost(id:number):Observable<Comment[]>{
    return this.http.get<Comment[]>(`${this.url}/${id}`);
  }
  searchCommentByCompanyPost(id:number):Observable<Comment[]>{
    return this.http.get<Comment[]>(`${this.urlCompanyPost}/${id}`);
  }
  save(newComment:Comment):Observable<Comment>{
    return this.http.post<Comment>(this.url,newComment);
  }
}
