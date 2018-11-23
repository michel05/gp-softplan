package br.com.michel.gpsoftplan.service;

import br.com.michel.gpsoftplan.domain.model.PersistentObject;

public interface GenericService {

    <T extends PersistentObject> T getById(Long id);
}
