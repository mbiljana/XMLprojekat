import { Injectable } from '@angular/core';
import { HttpClient ,HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Message} from "../app/model/message";



@Injectable({
  providedIn: 'root'
})
export class MessagingService {

  //samo proba za sve poruke
  url = "http://localhost:8191/api/users/allMess"
  constructor(private http: HttpClient) { }

  getAllMessages():Observable<Message[]>{
      return this.http.get<Message[]>(`${this.url}`);
  }
}
