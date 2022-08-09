import { UserSearch } from './../app/model/userSearch';
import { Injectable } from '@angular/core';
import { User } from 'src/app/model/user';
import { Observable } from 'rxjs';
import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  url = "http://localhost:8080/api/user";

  constructor(private http: HttpClient) { }

  searchUserByFirstAndLastName(user :UserSearch):Observable<User[]>{
    return this.http.post<User[]>(this.url,user);
  }
  getUser(id:number):Observable<User>{
    return this.http.get<User>(`${this.url}/${id}`);
  }
}
