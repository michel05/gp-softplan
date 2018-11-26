package br.com.michel.gpsoftplan.domain.repository;

import br.com.michel.gpsoftplan.domain.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findByUsuario(String usuario);

    List<Usuario> findAllByPerfisDescricao(String descricao);
}
