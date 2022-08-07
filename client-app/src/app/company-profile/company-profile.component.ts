import { Company } from './../model/company';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-company-profile',
  templateUrl: './company-profile.component.html',
  styleUrls: ['./company-profile.component.css']
})
export class CompanyProfileComponent implements OnInit {
  @Input()
  company:Company;
  

  constructor() { }

  ngOnInit(): void {
  }

}
