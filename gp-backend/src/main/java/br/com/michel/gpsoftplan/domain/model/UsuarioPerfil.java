package br.com.michel.gpsoftplan.domain.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "USUARIO_PERFIL")
public class UsuarioPerfil extends PersistentObject implements GrantedAuthority {

    private String descricao;

        @Override
    public String getAuthority() {
        return descricao;
    }
}
