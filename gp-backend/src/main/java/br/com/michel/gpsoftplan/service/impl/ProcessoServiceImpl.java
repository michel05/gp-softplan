package br.com.michel.gpsoftplan.service.impl;

import br.com.michel.gpsoftplan.domain.model.Processo;
import br.com.michel.gpsoftplan.domain.repository.ProcessoRepository;
import br.com.michel.gpsoftplan.service.ProcessoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProcessoServiceImpl implements ProcessoService {

    private final ProcessoRepository processoRepository;


    @Override
    public Processo getById(Long id) {
        return processoRepository.findById(id).orElse(null);
    }

    @Override
    public Processo save(Processo processo) {
        return processoRepository.save(processo);
    }

    @Override
    public List<Processo> findAllPedenteParecer(String username) {
        List<Processo> processos = new ArrayList<>();
        processoRepository.findAllByUsuariosUsuario(username).forEach(processos::add);
        return processos;
    }

    @Override
    public List<Processo> findAll() {
        List<Processo> processos = new ArrayList<>();
        processoRepository.findAll().forEach(processos::add);
        return processos;
    }

    @Override
    public void delete(Long id) {
        Processo processo = getById(id);
        if (processo != null) {
            processoRepository.delete(processo);
        }
    }
}
