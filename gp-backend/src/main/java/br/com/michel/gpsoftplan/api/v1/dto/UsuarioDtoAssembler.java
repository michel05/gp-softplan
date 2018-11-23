package br.com.michel.gpsoftplan.api.v1.dto;

import br.com.michel.gpsoftplan.api.v1.controller.UsuarioRestService;
import br.com.michel.gpsoftplan.domain.model.Usuario;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDtoAssembler extends ResourceAssemblerSupport<Usuario, UsuarioDto> {

    public UsuarioDtoAssembler() {
        super(UsuarioRestService.class, UsuarioDto.class);
    }

    @Override
    public UsuarioDto toResource(Usuario usuario) {
        UsuarioDto usuarioDto = createResourceWithId(usuario.getId(), usuario);
        usuarioDto.setNome(usuario.getNome());
        usuarioDto.setUsuario(usuario.getUsuario());
        addLinks(usuarioDto);
        return usuarioDto;
    }

    public Usuario toDomain(UsuarioDto usuarioDto) {
        return Usuario.builder()
                   .usuario(usuarioDto.getUsuario())
                   .build();
    }

    private void addLinks(UsuarioDto usuarioDto) {
        usuarioDto.add(new Link("http://localhost:8080/v1/foo", "foo"));
        usuarioDto.add(new Link("http://localhost:8080/v1/bar", "bar"));
    }
}
