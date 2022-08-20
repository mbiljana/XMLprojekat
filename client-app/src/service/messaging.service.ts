import { Injectable } from '@angular/core';
import { HttpClient ,HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Message} from "../app/model/message";
import {ChatDTO} from "../app/model/ChatDTO";
import {User} from "../app/model/user";
import {MessageDTO} from "../app/model/MessageDTO";



@Injectable({
  providedIn: 'root'
})
export class MessagingService {

  //samo proba za sve poruke
  url = "http://localhost:8191/api/messages/allMess";
  urlRecieved = "http://localhost:8191/api/messages/recMess";
  urlChat = "http://localhost:8191/api/messages/chat";
  urlMess = "http://localhost:8191/api/messages";
  urlSend = "http://localhost:8191/api/messages/sendMessage";
  constructor(private http: HttpClient) { }

  getAllMessages():Observable<Message[]>{
      return this.http.get<Message[]>(`${this.url}`);
  }

  getUserChat(id:number):Observable<Message[]>{
    return this.http.get<Message[]>(`${this.urlChat}/${id}`);
  }

  getMessagesWithUser(id:string,fid:string):Observable<Message[]>{
    return this.http.get<Message[]>(`${this.urlMess}/${id}/${fid}`);
  }

  //user send message
  sendMessage(mDTO : MessageDTO):Observable<Message>{
    return this.http.post<Message>(this.urlSend, mDTO);
  }
}
