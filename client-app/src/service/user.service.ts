import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import {User} from "../app/model/user";
import {FollowRequestsDTO} from "../app/model/FollowRequestsDTO";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url = "http://localhost:8191/api/users";
  urlBlock = "http://localhost:8184";

  constructor(private http: HttpClient) { }

  getUser(id:number):Observable<User>{
    return this.http.get<User>(`${this.url}/${id}`);
  }

  block(fDTO : FollowRequestsDTO):Observable<User>{
    return this.http.put<User>(this.urlBlock + "/blockUser",fDTO);
  }

}
