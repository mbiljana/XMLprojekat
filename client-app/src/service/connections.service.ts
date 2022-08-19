import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Message} from "../app/model/message";
import {ConnectionsNumberDTO} from "../app/model/ConnectionsNumberDTO";

@Injectable({
  providedIn: 'root'
})
export class ConnectionsService {

  url = "http://localhost:8191/api/following";
  urlNum = "http://localhost:8191/api/following/numConn";
  constructor(private http: HttpClient) {}

  //get all users that logged user is connected to
  getUsersConnections(id:number):Observable<string[]>{
    return this.http.get<string[]>(`${this.url}/${id}`);
  }

  //get number of connection logged user has
  getNumberOfConnections(id:number):Observable<ConnectionsNumberDTO>{
    return this.http.get<ConnectionsNumberDTO>(`${this.urlNum}/${id}`);
  }
}
