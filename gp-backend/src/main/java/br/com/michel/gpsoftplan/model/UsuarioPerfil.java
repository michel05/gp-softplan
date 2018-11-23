package br.com.michel.gpsoftplan.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "USUARIO_PERFIL")
public class UsuarioPerfil
//        implements GrantedAuthority
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    //    @Override
    public String getAuthority() {
        return descricao;
    }
}
