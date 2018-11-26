import { LoginService } from './security/login/login.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'gp-root',
  templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {
  title = 'gp-frontend';

  constructor(private loginService: LoginService) { }

  hasLoggedIn(): boolean {
    return this.loginService.isLoggedIn();
  }

  ngOnInit() {
  }
}
