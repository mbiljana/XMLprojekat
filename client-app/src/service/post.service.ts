import { Post } from './../app/model/post';
import { Injectable } from '@angular/core';
import { HttpClient ,HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import {MessageDTO} from "../app/model/MessageDTO";
import {Message} from "../app/model/message";
import {SearchJObDTO} from "../app/model/SearchJobDTO";
@Injectable({
  providedIn: 'root'
})
export class PostService {
  url = "http://localhost:8184/api/post";
  urlJob = "http://localhost:8184/api/post/search";
  urlPost = "http://localhost:8184/api/post/one";
  //url from agent app
  urlAg = "http://localhost:8083/api/post/search";

  constructor(private http: HttpClient) { }

  searchPostByCompany(id:number):Observable<Post[]>{
    return this.http.get<Post[]>(`${this.url}/${id}`);
  }
  searchJob(sDTO : SearchJObDTO):Observable<Post[]>{
    return this.http.post<Post[]>(this.urlJob, sDTO);
  }
  searchJobs(sDTO : SearchJObDTO):Observable<Post[]>{
    return this.http.post<Post[]>(this.urlAg, sDTO);
  }

  searchPost(id:number):Observable<Post>{
    return this.http.get<Post>(`${this.urlPost}/${id}`);
  }



}
