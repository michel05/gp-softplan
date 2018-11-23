package br.com.michel.gpsoftplan.domain.repository;

import br.com.michel.gpsoftplan.domain.model.UsuarioPerfil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioPerfilRepository extends CrudRepository<UsuarioPerfil, Long> {
    
}
