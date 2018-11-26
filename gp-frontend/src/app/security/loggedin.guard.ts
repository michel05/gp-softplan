import { LoginService } from './login/login.service';
import { CanLoad, Route, ActivatedRoute, ActivatedRouteSnapshot, RouterStateSnapshot, CanActivate } from '@angular/router';
import { Injectable } from '@angular/core';

@Injectable()
export class LoggedInGuard implements CanLoad, CanActivate {

  constructor(private loginService: LoginService) {}

  checkAuthentication(): boolean {
    const loggedIn = this.loginService.isLoggedIn();
    if (!loggedIn) {
      this.loginService.handleLogin();
    }

    return loggedIn;
  }

  canLoad(route: Route): boolean {
    console.log(route);
    return this.checkAuthentication();
  }

  canActivate(activateRoute: ActivatedRouteSnapshot, routerState: RouterStateSnapshot): boolean {
    console.log(activateRoute);
    return this.checkAuthentication();
  }
}
