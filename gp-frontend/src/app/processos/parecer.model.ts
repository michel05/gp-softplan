import { User } from 'src/app/security/login/user.model';
export class Parecer {
  constructor(public descricao: string, public usuarioFinalizador: User) {}

}
