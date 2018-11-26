import { LoginService } from './login/login.service';
import { Observable } from 'rxjs';
import { HttpInterceptor, HttpEvent, HttpRequest, HttpHandler } from '@angular/common/http';
import { Injectable, Injector } from '@angular/core';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private injector: Injector) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log("interceptando");
    const loginService = this.injector.get(LoginService);
    if (loginService.isLoggedIn()) {
      const authRequest = request.clone({setHeaders: {'Authorization': loginService.user.accessToken, 'Content-Type': 'application/json'}});
      console.log("autenticado " + authRequest);
      return next.handle(authRequest);
    } else {
      console.log("nao autenticado " + request);
      return next.handle(request);
    }
  }
}
