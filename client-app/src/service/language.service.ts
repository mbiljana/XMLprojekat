import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Language } from 'src/app/model/language';

@Injectable({
  providedIn: 'root'
})
export class LanguageService {

  url = "http://localhost:8184/api/language";

  constructor(private http: HttpClient) {}
   save(newLanguage:Language):Observable<Language>{
    return this.http.post<Language>(this.url,newLanguage);
  }
  getLanguage(id:number):Observable<Language>{
    return this.http.get<Language>(`${this.url}/${id}`);
  }
  findByName(name:string):Observable<Language>{
    const params:HttpParams=new HttpParams().append('name',name);
    return this.http.get<Language>(this.url,{params});
  }

}
