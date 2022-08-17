import { Injectable } from '@angular/core';
import { HttpClient ,HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Message} from "../app/model/message";
import {ChatDTO} from "../app/model/ChatDTO";



@Injectable({
  providedIn: 'root'
})
export class MessagingService {

  //samo proba za sve poruke
  url = "http://localhost:8191/api/messages/allMess";
  urlRecieved = "http://localhost:8191/api/messages/recMess";
  constructor(private http: HttpClient) { }

  getAllMessages():Observable<Message[]>{
      return this.http.get<Message[]>(`${this.url}`);
  }

  getAllMessagesForUser(chat : ChatDTO):Observable<ChatDTO>{
    const params:HttpParams=new HttpParams().append('reciever',chat.reciever);
    params.append('sender',chat.sender);
      return this.http.get<ChatDTO>(this.urlRecieved,{params});
  }
}
