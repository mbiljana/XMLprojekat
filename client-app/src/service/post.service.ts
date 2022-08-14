import { Post } from './../app/model/post';
import { Injectable } from '@angular/core';
import { HttpClient ,HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class PostService {
  url = "http://localhost:8184/api/post";

  constructor(private http: HttpClient) { }

  searchPostByCompany(id:number):Observable<Post[]>{
    return this.http.get<Post[]>(`${this.url}/${id}`);
  }
}
