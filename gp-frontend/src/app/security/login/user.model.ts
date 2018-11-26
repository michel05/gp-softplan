import { PerfilUsuario } from "src/app/usuarios/perfilUsuario.model";

export class User {

    cod: number;
    nome: string;
    usuario: string;
    senha: string;
    email: string;
    perfis: PerfilUsuario[];
    accessToken: string;
}
