import { LoginService } from './../security/login/login.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../security/login/user.model';

@Component({
  selector: 'gp-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {

  constructor(private loginService: LoginService) { }

  ngOnInit() {
  }

  user(): User {
    return this.loginService.user;
  }

}
