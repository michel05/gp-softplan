import { ProcessoService } from './processos/processo.service';
import { AuthInterceptor } from './security/auth.interception';
import { UsuariosService } from './usuarios/usuarios.service';
import { HttpClient, HttpHandler, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoggedInGuard } from './security/loggedin.guard';
import { LoginService } from './security/login/login.service';
import { ROUTES } from './routes';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HomeComponent } from './home/home.component';
import {APP_BASE_HREF} from '@angular/common';
import { LoginComponent } from './security/login/login.component';
import { UserDetailComponent } from './header/user-detail/user-detail.component';
import { ProcessosComponent } from './processos/processos.component';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { StatusComponent } from './status/status.component';
import { UsuarioFormComponent } from './usuarios/usuario-form/usuario-form.component';
import { ProcessoFormComponent } from './processos/processo-form/processo-form.component';
import { ParecerFormComponent } from './processos/parecer-form/parecer-form.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SidebarComponent,
    HomeComponent,
    LoginComponent,
    UserDetailComponent,
    ProcessosComponent,
    UsuariosComponent,
    StatusComponent,
    UsuarioFormComponent,
    ProcessoFormComponent,
    ParecerFormComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(ROUTES)
  ],
  providers: [
              UsuariosService,
              ProcessoService,
              HttpClient,
              LoginService,
              LoggedInGuard,
              {provide: APP_BASE_HREF, useValue: '/'},
              {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
