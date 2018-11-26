import { ProcessoService } from './../processo.service';
import { Processo } from './../processo.model';
import { UsuariosService } from './../../usuarios/usuarios.service';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from './../../security/login/login.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/security/login/user.model';

@Component({
  selector: 'gp-processo-form',
  templateUrl: './processo-form.component.html'
})
export class ProcessoFormComponent implements OnInit {

  processoForm: FormGroup;
  processo: Processo;
  usuariosFinalizadores: User[];

  constructor(private fb: FormBuilder,
              private loginService: LoginService,
              private router: Router,
              private usuariosService: UsuariosService,
              private processoServico: ProcessoService) { }

  ngOnInit() {
    this.processoForm = this.fb.group({
      descricao: this.fb.control('', [Validators.required]),
      finalizadores: this.fb.control('', [Validators.required])
    });
    this.usuariosService.buscarFinalizadores().subscribe(res => this.usuariosFinalizadores = res);
  }

  salvar() {
    this.processo = this.processoForm.value;
    console.log('salvando...');
    console.log(this.processo);
    this.processoServico.salvarProcesso(this.processo).subscribe(res => this.router.navigate(['/processos']));
  }

}
