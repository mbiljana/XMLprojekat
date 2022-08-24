import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Message} from "../app/model/message";
import {MessageNotif} from "../app/model/message-notification";

@Injectable({
  providedIn: 'root'
})
export class NotificationService {


  urlMess = "http://localhost:8191/api/notif";
  urlOne = "http://localhost:8191/api/notif/one";
  constructor(private http: HttpClient) { }

  //all users new message notifications
  getMessageNotifications(id:number):Observable<MessageNotif[]>{
    return this.http.get<MessageNotif[]>(`${this.urlMess}/${id}`);
  }

  getOneNotification(id:number):Observable<MessageNotif>{
    return this.http.get<MessageNotif>(`${this.urlOne}/${id}`);
  }




}
