import { Router } from '@angular/router';
import { LoginService } from './../security/login/login.service';
import { GP_API, VERSION_API } from './../app.api';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { Http, RequestOptions } from '@angular/http';

import { tap, map } from 'rxjs/operators';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Processo } from './processo.model';

@Injectable()
export class ProcessoService {

  processos: Processo[];

  constructor(private http: HttpClient,
              private loginService: LoginService,
              private router: Router) {}

  buscarProcessos(): Observable<Processo[]> {
    return this.http.get<Processo[]>(`${GP_API}/${VERSION_API}/processo`);
  }

  salvarProcesso(processo: Processo): Observable<any> {
    return this.http.post(`${GP_API}/${VERSION_API}/processo`,
                          JSON.stringify(processo))
        .pipe((tap(response => console.log(response))));
  }

  processoById(id: string): Observable<Processo> {
    return this.http.get<Processo>(`${GP_API}/${VERSION_API}/processo/${id}`);
  }

}
