package br.com.michel.gpsoftplan;

import br.com.michel.gpsoftplan.domain.model.Usuario;
import br.com.michel.gpsoftplan.domain.model.UsuarioPerfil;
import br.com.michel.gpsoftplan.domain.repository.UsuarioPerfilRepository;
import br.com.michel.gpsoftplan.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class InitDb implements CommandLineRunner {

    private UsuarioRepository usuarioRepository;
    private UsuarioPerfilRepository usuarioPerfilRepository;

    @Override
    public void run(String... strings) throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder(12);
        usuarioPerfilRepository.save(UsuarioPerfil.builder().descricao("USER_TRIADOR").build());
        usuarioPerfilRepository.save(UsuarioPerfil.builder().descricao("USER_FINALIZADOR").build());
        UsuarioPerfil usuarioPerfil = usuarioPerfilRepository.save(UsuarioPerfil.builder().descricao("ADMIN").build());
        Usuario usuario = Usuario.builder()
                .usuario("admin")
                .email("michel.ferreira.silva@gmail.com")
                .senha(encoder.encode("admin"))
                .perfis(Arrays.asList(usuarioPerfil))
                .build();
        usuario.setNome("Michel Ferreira");
        usuarioRepository.save(usuario);
    }
}
