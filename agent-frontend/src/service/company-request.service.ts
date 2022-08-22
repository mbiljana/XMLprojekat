import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CompanyRequest } from 'src/app/model/companyRequest';

@Injectable({
  providedIn: 'root'
})
export class CompanyRequestService {
  url = "http://localhost:8083/api/companyRequest";
  constructor(private http: HttpClient) { }

  save(newComoany:CompanyRequest):Observable<CompanyRequest>{
    return this.http.post<CompanyRequest>(this.url,newComoany);
  }
  approve(newComoany:CompanyRequest):Observable<CompanyRequest>{
    return this.http.post<CompanyRequest>(this.url+"/approve",newComoany);
  }
  getAll():Observable<CompanyRequest[]>{
    return this.http.get<CompanyRequest[]>(this.url)
  }
  getOne(id:number):Observable<CompanyRequest>{
    return this.http.get<CompanyRequest>(`${this.url}/${id}`);
  }
}
