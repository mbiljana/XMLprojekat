import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Message} from "../app/model/message";
import {UsersFollowRequestsDTO} from "../app/model/UsersFollowRequestsDTO";
import {Comment} from "../app/model/comment";
import {FollowRequestsDTO} from "../app/model/FollowRequestsDTO";
import {User} from "../app/model/user";
import {IsFollowingDTO} from "../app/model/IsFollowingDTO";

@Injectable({
  providedIn: 'root'
})
export class FollowReqService {


  url = "http://localhost:8191/api/users/requestsId";
  urlAccept = "http://localhost:8191/api/users/accept";
  urlFollow = "http://localhost:8191/api/users/follow";
  urlBool = "http://localhost:8191/api/users/following";
  urlBlock = "http://localhost:8191/api/users/blockUser";
  urlBlockUser = "http://localhost:8184/api/blockUser";
  urlBlockNum = "http://localhost:8191/api/users/blocksId";
  constructor(private http: HttpClient) { }


  getUsersFollowRequests(id:number):Observable<string[]>{
    return this.http.get<string[]>(`${this.url}/${id}`);
  }

  acceptRequest(fDTO : FollowRequestsDTO):Observable<String>{
    return this.http.post<String>(this.urlAccept,fDTO);
  }


  /*
  acceptRequest(un:string,fun:string):Observable<User>{
    return this.http.get<User>(`${this.urlAccept}/${un}/${fun}`);
  }

   */

  isFollowing(fDTO: IsFollowingDTO):Observable<boolean>{
    return this.http.post<boolean>(this.urlBool, fDTO);
  }

  block(fDTO : FollowRequestsDTO):Observable<String>{
    return this.http.post<String>(this.urlBlock,fDTO);
  }

  getBlocked(id:number):Observable<string[]>{
    return this.http.get<string[]>(`${this.urlBlockNum}/${id}`);
  }

  blockProfile(fDTO : FollowRequestsDTO):Observable<String>{
    return this.http.post<String>(this.urlBlock,fDTO);
  }









}
