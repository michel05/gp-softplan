package br.com.michel.gpsoftplan.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity(name = "USUARIO")
public class Usuario extends Pessoa {

    private String usuario;
    private String senha;

    @OneToMany
    private List<UsuarioPerfil> perfis;

//    @Override
//    public Collection<UsuarioPerfil> getAuthorities() {
//        return perfis;
//    }
//
//    @Override
//    public String getPassword() {
//        return senha;
//    }
//
//    @Override
//    public String getUsername() {
//        return usuario;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
