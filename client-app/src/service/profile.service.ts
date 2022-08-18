import { Profile } from './../app/model/profile';
import { UserSearch } from './../app/model/userSearch';
import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import {User} from "../app/model/user";
import {FollowRequestsDTO} from "../app/model/FollowRequestsDTO";
import {ConnectionsNumberDTO} from "../app/model/ConnectionsNumberDTO";

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  url = "http://localhost:8184/api/user";
  urlProfile="http://localhost:8184/api/profile";
  urlFollow = "http://localhost:8191/api/users/follow";
  urlFollowing = "http://localhost:8191/api/following";
  urlUser = "http://localhost:8191/api/users";

  constructor(private http: HttpClient) { }

  searchUserByFirstAndLastName(user :UserSearch):Observable<User[]>{
    return this.http.post<User[]>(this.url,user);
  }
  getUser(id:number):Observable<User>{
    return this.http.get<User>(`${this.url}/${id}`);
  }
  getUserByUsername(un:string):Observable<User>{
    return this.http.get<User>(`${this.urlUser}/${un}`);
  }
  getProfile(id:number):Observable<Profile>{
    return this.http.get<Profile>(`${this.urlProfile}/${id}`);
  }

  followUser(fDTO : FollowRequestsDTO):Observable<User>{
    return this.http.put<User>(this.urlFollow, fDTO);
  }

  /*
  getNumConnections(username:string):Observable<ConnectionsNumberDTO>{
    return this.http.get<ConnectionsNumberDTO>(this.urlFollowing, username);
  }

   */
}
