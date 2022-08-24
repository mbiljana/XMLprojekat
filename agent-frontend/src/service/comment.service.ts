import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Comment } from 'src/app/model/comment';

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  url = "http://localhost:8083/api/comment";
  constructor(private http: HttpClient) { }

  save(newComment:Comment):Observable<Comment>{
    return this.http.post<Comment>(this.url,newComment);
  }
  getAllByCompanyId(id:number):Observable<Comment[]>{
    return this.http.get<Comment[]>(`${this.url+"/company"}/${id}`);
  }
}
