import { Parecer } from './parecer.model';
import { User } from 'src/app/security/login/user.model';
export class Processo {
  constructor(public descricao: string) {}

  cod: string;
  finalizadores: User[];
  parecer: Parecer;

}
