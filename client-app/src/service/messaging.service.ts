import { Injectable } from '@angular/core';
import { HttpClient ,HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Message} from "../app/model/message";
import {ChatDTO} from "../app/model/ChatDTO";
import {User} from "../app/model/user";



@Injectable({
  providedIn: 'root'
})
export class MessagingService {

  //samo proba za sve poruke
  url = "http://localhost:8191/api/messages/allMess";
  urlRecieved = "http://localhost:8191/api/messages/recMess";
  urlChat = "http://localhost:8191/api/messages/chat";
  constructor(private http: HttpClient) { }

  getAllMessages():Observable<Message[]>{
      return this.http.get<Message[]>(`${this.url}`);
  }

  getUserChat(id:number):Observable<Message[]>{
    return this.http.get<Message[]>(`${this.urlChat}/${id}`);
  }
}
