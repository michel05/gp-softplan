package br.com.michel.gpsoftplan.service;

import br.com.michel.gpsoftplan.domain.model.Processo;

import java.util.List;

public interface ProcessoService extends GenericService  {

    Processo getById(Long id);
    Processo save(Processo processo);
    List<Processo> findAllPedenteParecer(String username);
}
