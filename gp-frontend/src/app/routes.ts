import { ParecerFormComponent } from './processos/parecer-form/parecer-form.component';
import { ProcessoFormComponent } from './processos/processo-form/processo-form.component';
import { UsuarioFormComponent } from './usuarios/usuario-form/usuario-form.component';
import { ProcessosComponent } from './processos/processos.component';
import { StatusComponent } from './status/status.component';
import { LoggedInGuard } from './security/loggedin.guard';
import { LoginComponent } from './security/login/login.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';

import {Routes} from '@angular/router';
import { UsuariosComponent } from './usuarios/usuarios.component';

export const ROUTES: Routes = [
    {path: '', component: HomeComponent, canActivate: [LoggedInGuard], canLoad: [LoggedInGuard]},
    {path: 'home', component: HomeComponent, canActivate: [LoggedInGuard], canLoad: [LoggedInGuard]},
    {path: 'usuarios', component: UsuariosComponent, canActivate: [LoggedInGuard], canLoad: [LoggedInGuard]},
    {path: 'usuarios/form', component: UsuarioFormComponent, canActivate: [LoggedInGuard]},
    {path: 'usuarios/form/:id', component: UsuarioFormComponent, canActivate: [LoggedInGuard]},
    {path: 'processos', component: ProcessosComponent, canActivate: [LoggedInGuard], canLoad: [LoggedInGuard]},
    {path: 'processos/form', component: ProcessoFormComponent, canActivate: [LoggedInGuard]},
    {path: 'processos/:id', component: ParecerFormComponent, canActivate: [LoggedInGuard]},
    {path: '403', component: StatusComponent, canActivate: [LoggedInGuard], canLoad: [LoggedInGuard]},
    {path: 'login', component: LoginComponent}

];
