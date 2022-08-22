import { CompanyRequestService } from 'src/service/company-request.service';
import { CompanyRequest } from './../model/companyRequest';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-company-request-list',
  templateUrl: './company-request-list.component.html',
  styleUrls: ['./company-request-list.component.css']
})
export class CompanyRequestListComponent implements OnInit {
  requests:CompanyRequest[];
  constructor(private companyRequestService: CompanyRequestService) {
    this.requests=[];
  }

  ngOnInit(): void {
    this.loadRequest()
  }
  loadRequest(){
    this.companyRequestService.getAll()
    .subscribe(res=>this.requests=res)
  }

}
