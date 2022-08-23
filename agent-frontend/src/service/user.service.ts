import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/model/user';
import {UpdateUser} from "../app/model/udate-user";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url = "http://localhost:8083/api/user";
  urlUpdate = "http://localhost:8083/api/user/update";

  constructor(private http: HttpClient) { }

  getUser(id:number):Observable<User>{
    return this.http.get<User>(`${this.url}/${id}`);
  }

  updateUser(user:UpdateUser):Observable<User>{
    return this.http.put<User>(this.urlUpdate, user);
  }
}
