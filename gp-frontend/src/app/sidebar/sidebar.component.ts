import { User } from './../security/login/user.model';
import { LoginService } from './../security/login/login.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'gp-sidebar',
  templateUrl: './sidebar.component.html'
})
export class SidebarComponent implements OnInit {

  constructor(private loginService: LoginService) { }

  ngOnInit() {
  }

  user(): User {
    return this.loginService.user;
  }

}
