import { User } from './../../security/login/user.model';
import { LoginService } from './../../security/login/login.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'gp-user-detail',
  templateUrl: './user-detail.component.html'
})
export class UserDetailComponent implements OnInit {

  constructor(private loginService: LoginService) { }

  ngOnInit() {
  }

  user(): User {
    return this.loginService.user;
  }

 isLoggedIn(): boolean {
  return this.loginService.isLoggedIn();
 }

 logout() {
   return this.loginService.logout();
 }

}
