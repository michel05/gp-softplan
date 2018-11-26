import { ProcessoService } from './../processo.service';
import { UsuariosService } from './../../usuarios/usuarios.service';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from './../../security/login/login.service';
import { Processo } from './../processo.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/security/login/user.model';
import { Parecer } from '../parecer.model';

@Component({
  selector: 'gp-parecer-form',
  templateUrl: './parecer-form.component.html'
})
export class ParecerFormComponent implements OnInit {

  parecerForm: FormGroup;
  processo: Processo;
  usuariosFinalizadores: User[];

  constructor(private fb: FormBuilder,
              private loginService: LoginService,
              private router: Router,
              private usuariosService: UsuariosService,
              private processoServico: ProcessoService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.parecerForm = this.fb.group({
      descricaoParecer: this.fb.control('', [Validators.required])
    });

    if (this.route.snapshot.params['id'] !== undefined) {
      this.processoServico.processoById(this.route.snapshot.params['id'])
        .subscribe(processo => {
          this.processo = processo;
        });
    }
    this.usuariosService.buscarFinalizadores().subscribe(res => this.usuariosFinalizadores = res);
  }

  salvar() {
    this.processo.parecer = new Parecer(this.parecerForm.get('descricaoParecer').value,
                                        this.loginService.user);
    this.processo.finalizadores = null;
    console.log("Processo com parecer");
    console.log(this.processo);
    this.processoServico.salvarProcesso(this.processo)
                        .subscribe(res => this.router.navigate(['/processos']));
  }

}
