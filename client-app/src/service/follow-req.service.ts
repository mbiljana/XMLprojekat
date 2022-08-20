import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Message} from "../app/model/message";
import {UsersFollowRequestsDTO} from "../app/model/UsersFollowRequestsDTO";
import {Comment} from "../app/model/comment";
import {FollowRequestsDTO} from "../app/model/FollowRequestsDTO";
import {User} from "../app/model/user";

@Injectable({
  providedIn: 'root'
})
export class FollowReqService {


  url = "http://localhost:8191/api/users/requestsId";
  urlAccept = "http://localhost:8191/api/users/accept";
  urlFollow = "http://localhost:8191/api/users/follow";
  constructor(private http: HttpClient) { }


  getUsersFollowRequests(id:number):Observable<string[]>{
    return this.http.get<string[]>(`${this.url}/${id}`);
  }

  acceptRequest(request : FollowRequestsDTO):Observable<string>{
    return this.http.put<string>(this.urlAccept,request);
  }








}
