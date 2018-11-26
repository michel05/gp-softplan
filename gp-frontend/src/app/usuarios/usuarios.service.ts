import { Router } from '@angular/router';
import { User } from 'src/app/security/login/user.model';
import { PerfilUsuario } from './perfilUsuario.model';
import { LoginService } from './../security/login/login.service';
import { GP_API, VERSION_API } from './../app.api';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { Http, RequestOptions } from '@angular/http';

import { tap, map } from 'rxjs/operators';
import { HttpHeaders, HttpClient } from '@angular/common/http';

@Injectable()
export class UsuariosService {

  users: User[];

  constructor(private http: HttpClient,
              private loginService: LoginService,
              private router: Router) {}

  usuarios(): Observable<User[]> {
    return this.http.get<User[]>(`${GP_API}/${VERSION_API}/usuario`);
  }

  buscarFinalizadores(): Observable<User[]> {
    return this.http.get<User[]>(`${GP_API}/${VERSION_API}/finalizadores`);
  }

  perfisUsuario(): Observable<PerfilUsuario[]> {
    return this.http.get<PerfilUsuario[]>(`${GP_API}/${VERSION_API}/perfil`);
  }

  usuarioById(id: string): Observable<User> {
    return this.http.get<User>(`${GP_API}/${VERSION_API}/usuario/${id}`);
  }

  salvarUsuario(user: User): Observable<any> {
    return this.http.post(`${GP_API}/${VERSION_API}/usuario`,
                          JSON.stringify(user))
        .pipe((tap(response => console.log(response))));
  }

  deletarUsuario(id: number): Observable<any> {
    return this.http.delete(`${GP_API}/${VERSION_API}/usuario/${id}`);
  }
}
