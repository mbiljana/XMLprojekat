import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import {User} from "../app/model/user";
import {FollowRequestsDTO} from "../app/model/FollowRequestsDTO";
import {UserRequest} from "../app/model/UserRequest";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url = "http://localhost:8191/api/users";
  urlSave = "http://localhost:8191/api/users/save";
  urlBlock = "http://localhost:8184";
  urlSaveProfileUser = "http://localhost:8184/api/user/create";

  constructor(private http: HttpClient) { }

  getUser(id:number):Observable<User>{
    return this.http.get<User>(`${this.url}/${id}`);
  }

  block(fDTO : FollowRequestsDTO):Observable<User>{
    return this.http.put<User>(this.urlBlock + "/blockUser",fDTO);
  }
  saveUser(user : User):Observable<User>{
    return this.http.post<User>(this.urlSave,user);
  }
  saveUserProfile(user : User):Observable<User>{
    return this.http.post<User>(this.urlSaveProfileUser,user);
  }


}
