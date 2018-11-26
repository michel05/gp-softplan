package br.com.michel.gpsoftplan.api.v1.controller;

import br.com.michel.gpsoftplan.api.v1.dto.UsuarioDto;
import br.com.michel.gpsoftplan.api.v1.dto.UsuarioDtoAssembler;
import br.com.michel.gpsoftplan.api.v1.dto.UsuarioPerfilDto;
import br.com.michel.gpsoftplan.api.v1.dto.UsuarioPerfilDtoAssembler;
import br.com.michel.gpsoftplan.domain.model.UsuarioPerfil;
import br.com.michel.gpsoftplan.service.UsuarioPerfilService;
import br.com.michel.gpsoftplan.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("v1/perfil")
public class UsuarioPerfilRestService {

    private final UsuarioPerfilService usuarioPerfilService;
    private final UsuarioPerfilDtoAssembler usuarioPerfilDtoAssembler;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public List<UsuarioPerfilDto> getAll() {
        List<UsuarioPerfil> perfis = usuarioPerfilService.findAll();
        return usuarioPerfilDtoAssembler.toResource(perfis);
    }


}
