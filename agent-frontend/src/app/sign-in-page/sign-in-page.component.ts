import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sign-in-page',
  templateUrl: './sign-in-page.component.html',
  styleUrls: ['./sign-in-page.component.css']
})
export class SignInPageComponent implements OnInit {
  error:string;
  username: any
  password = ''
  invalidLogin = false;
  constructor() { }

  ngOnInit(): void {
  }
  login(){}
}