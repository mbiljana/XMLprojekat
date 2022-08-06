import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Company } from '../model/company';

@Component({
  selector: 'app-found-company',
  templateUrl: './found-company.component.html',
  styleUrls: ['./found-company.component.css']
})
export class FoundCompanyComponent implements OnInit {
  @Input()
  company:Company;

  @Output()
  ViewProfile: EventEmitter<Company>=new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }
  viewProfile(){
    this.ViewProfile.next(this.company);
  }
}
