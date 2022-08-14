import { Company } from './../app/model/company';
import { HttpClient ,HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  url = "http://localhost:8184/api/company";

  constructor(private http: HttpClient) { }

  searchCompanyName(name:string):Observable<Company>{
    const params:HttpParams=new HttpParams().append('name',name);
    return this.http.get<Company>(this.url,{params});
  }
}
