import { Router } from '@angular/router';
import { LoginService } from './../security/login/login.service';
import { UsuariosService } from './usuarios.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../security/login/user.model';

@Component({
  selector: 'gp-usuarios',
  templateUrl: './usuarios.component.html'
})
export class UsuariosComponent implements OnInit {

  constructor(private usuariosService: UsuariosService,
              private loginService: LoginService,
              private router: Router) { }

  ngOnInit() {
    this.usuariosService.usuarios()
    .subscribe(usuarios => this.usuariosService.users = usuarios);
  }

  getUsers(): User[] {
    return this.usuariosService.users;
  }

  excluir(cod: number) {
    this.usuariosService.deletarUsuario(cod)
        .subscribe(res => {
          this.usuariosService.usuarios()
          .subscribe(usuarios => this.usuariosService.users = usuarios);
        });
  }

  naoEhUsuarioCorrente(cod: number): boolean {
    return this.loginService.user.cod !== cod;
  }


}
