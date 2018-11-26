package br.com.michel.gpsoftplan.domain.repository;

import br.com.michel.gpsoftplan.domain.model.Processo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessoRepository extends CrudRepository<Processo, Long> {

    List<Processo> findAllByUsuariosUsuario(String username);
}
