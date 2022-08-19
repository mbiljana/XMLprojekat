import { Company } from './../app/model/company';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  url = "http://localhost:8083/api/company";
  constructor(private http: HttpClient) { }

  save(newComoany:Company):Observable<Company>{
    return this.http.post<Company>(this.url,newComoany);
  }
}
