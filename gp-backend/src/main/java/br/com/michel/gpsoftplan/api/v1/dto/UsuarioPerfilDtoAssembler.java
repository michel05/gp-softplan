package br.com.michel.gpsoftplan.api.v1.dto;

import br.com.michel.gpsoftplan.api.v1.controller.UsuarioPerfilRestService;
import br.com.michel.gpsoftplan.domain.model.UsuarioPerfil;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioPerfilDtoAssembler extends ResourceAssemblerSupport<UsuarioPerfil, UsuarioPerfilDto> {

    public UsuarioPerfilDtoAssembler() {
        super(UsuarioPerfilRestService.class, UsuarioPerfilDto.class);
    }

    @Override
    public UsuarioPerfilDto toResource(UsuarioPerfil usuarioPerfil) {
        UsuarioPerfilDto usuarioPerfilDto = createResourceWithId(usuarioPerfil.getId(), usuarioPerfil);
        usuarioPerfilDto.setCod(usuarioPerfil.getId());
        usuarioPerfilDto.setDescricao(usuarioPerfil.getDescricao());
        return usuarioPerfilDto;
    }

    public List<UsuarioPerfilDto> toResource(List<UsuarioPerfil> perfis) {
        List<UsuarioPerfilDto> perfisDtos = new ArrayList<>();
        perfis.forEach(x -> perfisDtos.add(toResource(x)));
        return perfisDtos;
    }

    public UsuarioPerfil toDomain(UsuarioPerfilDto perfilDto) {
        UsuarioPerfil usuarioPerfil = new UsuarioPerfil();
        usuarioPerfil.setId(perfilDto.getCod());
        usuarioPerfil.setDescricao(perfilDto.getDescricao());
        return  usuarioPerfil;
    }
}
