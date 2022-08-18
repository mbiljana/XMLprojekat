import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UserRequest} from "../app/model/UserRequest";
import {Observable} from "rxjs";
import {User} from "../app/model/user";

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  url = "http://localhost:8082/auth/signup";
  constructor(private http: HttpClient) { }

  registerUser(newUser: UserRequest): Observable<User> {
    return this.http.post<User>(this.url, newUser);
  }
}
