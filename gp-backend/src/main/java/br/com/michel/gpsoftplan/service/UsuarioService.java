package br.com.michel.gpsoftplan.service;

import br.com.michel.gpsoftplan.domain.model.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioService extends GenericService  {

    Usuario getById(Long id);
    Usuario save(Usuario usuario);
    List<Usuario> findAllByPerfil(String perfil);
}
