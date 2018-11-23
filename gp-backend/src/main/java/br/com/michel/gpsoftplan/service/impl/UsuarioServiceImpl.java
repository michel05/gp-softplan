package br.com.michel.gpsoftplan.service.impl;

import br.com.michel.gpsoftplan.domain.model.Usuario;
import br.com.michel.gpsoftplan.domain.repository.UsuarioRepository;
import br.com.michel.gpsoftplan.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario getById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
