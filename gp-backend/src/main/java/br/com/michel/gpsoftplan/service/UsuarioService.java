package br.com.michel.gpsoftplan.service;

import br.com.michel.gpsoftplan.domain.model.Usuario;

public interface UsuarioService extends GenericService {

    Usuario getById(Long id);
    Usuario save(Usuario usuario);
}
