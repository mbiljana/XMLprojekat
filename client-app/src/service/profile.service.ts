import { Profile } from './../app/model/profile';
import { UserSearch } from './../app/model/userSearch';
import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import {User} from "../app/model/user";
import {FollowRequestsDTO} from "../app/model/FollowRequestsDTO";

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  url = "http://localhost:8184/api/user";
  urlProfile="http://localhost:8184/api/profile";
  urlFollow = "http://localhost:8191/api/users/follow"

  constructor(private http: HttpClient) { }

  searchUserByFirstAndLastName(user :UserSearch):Observable<User[]>{
    return this.http.post<User[]>(this.url,user);
  }
  getUser(id:number):Observable<User>{
    return this.http.get<User>(`${this.url}/${id}`);
  }
  getProfile(id:number):Observable<Profile>{
    return this.http.get<Profile>(`${this.urlProfile}/${id}`);
  }
  updateProfile(profile:Profile):Observable<Profile>{
    return this.http.put<Profile>(this.urlProfile+ "/update", profile);
  }

  followUser(fDTO : FollowRequestsDTO):Observable<String>{
    return this.http.put<String>(this.urlFollow, fDTO);
  }
}
