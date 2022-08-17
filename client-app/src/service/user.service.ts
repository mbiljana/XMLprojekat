import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import {User} from "../app/model/user";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url = "http://localhost:8191/api/users";

  constructor(private http: HttpClient) { }

  getUser(id:number):Observable<User>{
    return this.http.get<User>(`${this.url}/${id}`);
  }

}
