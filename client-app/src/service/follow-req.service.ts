import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Message} from "../app/model/message";
import {UsersFollowRequestsDTO} from "../app/model/UsersFollowRequestsDTO";
import {Comment} from "../app/model/comment";
import {FollowRequestsDTO} from "../app/model/FollowRequestsDTO";

@Injectable({
  providedIn: 'root'
})
export class FollowReqService {


  url = "http://localhost:8191/api/users/requests";
  urlAccept = "http://localhost:8191/api/users/accept";

  constructor(private http: HttpClient) { }


  getUsersFollowRequests(requests : UsersFollowRequestsDTO):Observable<String[]>{
    return this.http.post<String[]>(this.url,requests);
  }

  acceptRequest(request : FollowRequestsDTO):Observable<String[]>{
    return this.http.put<String[]>(this.urlAccept,request);
  }






}
