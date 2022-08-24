import { Company } from './../app/model/company';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {UpdateUser} from "../app/model/udate-user";
import {User} from "../app/model/user";
import {UpdateCompany} from "../app/model/company-update";

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  url = "http://localhost:8083/api/company";
  urlUpdate = "http://localhost:8083/company/update";

  constructor(private http: HttpClient) { }

  save(newComoany:Company):Observable<Company>{
    return this.http.post<Company>(this.url,newComoany);
  }
  getOneByOwnerId(id:number):Observable<Company>{
    return this.http.get<Company>(`${this.url+"/owner"}/${id}`);
  }

  updateCompany(company:UpdateCompany):Observable<Company>{
    return this.http.post<Company>(this.urlUpdate, company);
  }
}
