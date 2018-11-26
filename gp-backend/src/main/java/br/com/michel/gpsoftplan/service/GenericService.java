package br.com.michel.gpsoftplan.service;

import br.com.michel.gpsoftplan.domain.model.PersistentObject;
import br.com.michel.gpsoftplan.domain.model.Usuario;

import java.util.List;

public interface GenericService {

    <T extends PersistentObject> T getById(Long id);

    <T extends PersistentObject> List<T> findAll();

    void delete(Long id);
}
