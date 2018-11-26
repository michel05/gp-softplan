import { PerfilUsuario } from './../perfilUsuario.model';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from './../../security/login/login.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UsuariosService } from './../usuarios.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/security/login/user.model';

@Component({
  selector: 'gp-usuario-form',
  templateUrl: './usuario-form.component.html'
})
export class UsuarioFormComponent implements OnInit {

  userForm: FormGroup;
  user: User = null;
  perfis: PerfilUsuario[];

  constructor(private usuariosService: UsuariosService,
              private fb: FormBuilder,
              private loginService: LoginService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.usuariosService.perfisUsuario().subscribe(perfils => this.perfis = perfils);
    this.userForm = this.fb.group({
      cod: this.fb.control('').disabled,
      nome: this.fb.control('', [Validators.required]),
      usuario: this.fb.control('', [Validators.required]),
      email: this.fb.control('', [Validators.required]),
      perfis: this.fb.control('', [Validators.required]),
      senha: this.fb.control('', [Validators.required])
    });

    if (this.route.snapshot.params['id'] !== undefined) {
      this.usuariosService.usuarioById(this.route.snapshot.params['id'])
        .subscribe(user => {
          this.user = user;
          this.userForm.get('cod').setValue(user.cod);
          this.userForm.get('nome').setValue(user.nome);
          this.userForm.get('usuario').setValue(user.usuario);
          this.userForm.get('email').setValue(user.email);
          this.userForm.get('perfis').setValue(user.perfis);
          this.userForm.get('senha').setValue(user.senha);
        });
    }
  }

  salvar() {
    this.user = this.userForm.value;
    if (!this.userForm.get('cod').value) {
      this.user.cod = null;
    }
    console.log(this.userForm);
    console.log('salvando...');
    console.log(this.user);
    this.usuariosService.salvarUsuario(this.user).subscribe(res => this.router.navigate(['/usuarios']));
  }


}
