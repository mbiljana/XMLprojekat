import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Message} from "../app/model/message";
import {MessageNotif} from "../app/model/message-notification";
import {User} from "../app/model/user";

@Injectable({
  providedIn: 'root'
})
export class NotificationService {


  urlMess = "http://localhost:8191/api/notif";
  urlPost = "http://localhost:8191/api/notif/post";
  urlOne = "http://localhost:8191/api/notif/one";
  urlSavePost = "http://localhost:8191/api/notif/save";
  constructor(private http: HttpClient) { }

  //all users new message notifications
  getMessageNotifications(id:number):Observable<MessageNotif[]>{
    return this.http.get<MessageNotif[]>(`${this.urlMess}/${id}`);
  }

  //all users new message notifications
  getPostNotifications(id:number):Observable<MessageNotif[]>{
    return this.http.get<MessageNotif[]>(`${this.urlPost}/${id}`);
  }

  //all users new post notifications

  getOneNotification(id:number):Observable<MessageNotif>{
    return this.http.get<MessageNotif>(`${this.urlOne}/${id}`);
  }



  savePostNotif(id:number):Observable<User>{
    return this.http.get<User>(`${this.urlSavePost}/${id}`)
  }




}
