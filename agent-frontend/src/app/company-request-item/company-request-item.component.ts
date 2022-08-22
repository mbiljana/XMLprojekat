import { CompanyRequest } from 'src/app/model/companyRequest';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'tr[app-company-request-item]',
  templateUrl: './company-request-item.component.html',
  styleUrls: ['./company-request-item.component.css']
})
export class CompanyRequestItemComponent implements OnInit {
@Input()
request:CompanyRequest;
  constructor() { }

  ngOnInit(): void {
  }

}
