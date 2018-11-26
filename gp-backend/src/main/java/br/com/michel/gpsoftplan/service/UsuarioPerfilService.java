package br.com.michel.gpsoftplan.service;

import br.com.michel.gpsoftplan.domain.model.Usuario;
import br.com.michel.gpsoftplan.domain.model.UsuarioPerfil;

public interface UsuarioPerfilService extends GenericService  {

    UsuarioPerfil getById(Long id);
    UsuarioPerfil save(UsuarioPerfil usuarioPerfil);
}
