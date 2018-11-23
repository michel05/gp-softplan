package br.com.michel.gpsoftplan.domain.repository;

import br.com.michel.gpsoftplan.domain.model.Processo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoRepository extends CrudRepository<Processo, Long> {
    
}
