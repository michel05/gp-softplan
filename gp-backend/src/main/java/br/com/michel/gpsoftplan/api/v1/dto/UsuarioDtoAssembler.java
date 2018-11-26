package br.com.michel.gpsoftplan.api.v1.dto;

import br.com.michel.gpsoftplan.api.v1.controller.UsuarioRestService;
import br.com.michel.gpsoftplan.domain.model.Usuario;
import br.com.michel.gpsoftplan.domain.model.UsuarioPerfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioDtoAssembler extends ResourceAssemblerSupport<Usuario, UsuarioDto> {

    private UsuarioPerfilDtoAssembler usuarioPerfilDtoAssembler = new UsuarioPerfilDtoAssembler();
    public UsuarioDtoAssembler() {
        super(UsuarioRestService.class, UsuarioDto.class);
    }

    @Override
    public UsuarioDto toResource(Usuario usuario) {
        UsuarioDto usuarioDto = createResourceWithId(usuario.getId(), usuario);
        usuarioDto.setCod(usuario.getId());
        usuarioDto.setNome(usuario.getNome());
        usuarioDto.setUsuario(usuario.getUsuario());
        usuarioDto.setEmail(usuario.getEmail());
        usuarioDto.setPerfis(usuario.getPerfis() != null ? usuarioPerfilDtoAssembler.toResource(usuario.getPerfis()) : null);
        return usuarioDto;
    }

    public List<UsuarioDto> toResource(List<Usuario> usuarios) {
        List<UsuarioDto> usuarioDtos = new ArrayList<>();
        usuarios.forEach(x -> usuarioDtos.add(toResource(x)));
        return usuarioDtos;
    }

    public Usuario toDomain(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        if(usuarioDto.getCod() != null) {
            usuario.setId(usuarioDto.getCod());
        }
        usuario.setNome(usuarioDto.getNome());
        usuario.setUsuario(usuarioDto.getUsuario());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setSenha(usuarioDto.getSenha());

        List<UsuarioPerfilDto> perfils = usuarioDto.getPerfis();
        if(perfils != null && !perfils.isEmpty()) {
            List<UsuarioPerfil> perfis = new ArrayList<>();
            for (UsuarioPerfilDto perfil : perfils) {
                UsuarioPerfil usuarioPerfil = new UsuarioPerfil();
                usuarioPerfil.setId(perfil.getCod());
                perfis.add(usuarioPerfil);
            }
            usuario.setPerfis(perfis);
        }

        return usuario;
    }

    private void addLinks(UsuarioDto usuarioDto) {
        usuarioDto.add(new Link("http://localhost:8080/v1/foo", "foo"));
        usuarioDto.add(new Link("http://localhost:8080/v1/bar", "bar"));
    }
}
