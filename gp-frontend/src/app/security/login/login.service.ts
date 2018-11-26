

import { User } from './user.model';
import { GP_API } from './../../app.api';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap, map } from 'rxjs/operators';
import { Router } from '@angular/router';


@Injectable()
export class LoginService {

  user: User;

  constructor(private http: HttpClient, private router: Router) {}

  isLoggedIn(): boolean {
    return this.user !== undefined;
  }

  login(usuario: string, password: string): Observable<User> {
    const userJson = {usuario: usuario, senha: password};
    console.log(userJson);
    return this.http.post<User>(`${GP_API}/login`, userJson)
                    .pipe(tap(user => this.user = user));
  }

  handleLogin() {
    this.router.navigate(['/login']);
  }

  logout() {
    this.user = undefined;
    this.handleLogin();
  }
}
