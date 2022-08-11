import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import {User} from "../app/model/user";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url = "http://localhost:8191/api/users";
  followUrl = "http://localhost:8191/api/users/follow";

  constructor(private http: HttpClient) { }

  //followUser()
  //return this.http.put

}
