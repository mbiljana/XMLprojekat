import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';

@Component({
  selector: 'app-sign-in-page',
  templateUrl: './sign-in-page.component.html',
  styleUrls: ['./sign-in-page.component.css']
})
export class SignInPageComponent implements OnInit {
  username: any
  password = ''
  invalidLogin = false;
  @Output()
  LogIn: EventEmitter<void> = new EventEmitter();

  @Input() error: string | null;
  constructor() { }

  ngOnInit(): void {
  }
  login(){}
}
