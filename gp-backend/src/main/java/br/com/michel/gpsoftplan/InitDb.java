package br.com.michel.gpsoftplan;

import br.com.michel.gpsoftplan.domain.model.Usuario;
import br.com.michel.gpsoftplan.domain.model.UsuarioPerfil;
import br.com.michel.gpsoftplan.domain.repository.UsuarioPerfilRepository;
import br.com.michel.gpsoftplan.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class InitDb implements CommandLineRunner {

    private UsuarioRepository usuarioRepository;
    private UsuarioPerfilRepository usuarioPerfilRepository;

    @Override
    public void run(String... strings) throws Exception {
        UsuarioPerfil usuarioPerfil = usuarioPerfilRepository.save(UsuarioPerfil.builder().descricao("ADMIN").build());
        usuarioRepository.save(Usuario.builder()
                                      .usuario("michel")
                                      .senha("123")
                                      .perfis(Arrays.asList(usuarioPerfil))
                                      .build());
    }
}
