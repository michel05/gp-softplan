import { ProcessoService } from './processo.service';
import { User } from 'src/app/security/login/user.model';
import { UsuariosService } from './../usuarios/usuarios.service';
import { Processo } from './processo.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'gp-processos',
  templateUrl: './processos.component.html'
})
export class ProcessosComponent implements OnInit {

  constructor(private processoService: ProcessoService) { }

  ngOnInit() {
    this.processoService.buscarProcessos()
        .subscribe(processos => this.processoService.processos = processos);
  }

  getProcessos(): Processo[] {
    return this.processoService.processos;
  }

}
