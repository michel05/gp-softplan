package br.com.michel.gpsoftplan.api.v1.controller;

import br.com.michel.gpsoftplan.api.v1.dto.UsuarioDto;
import br.com.michel.gpsoftplan.api.v1.dto.UsuarioDtoAssembler;
import br.com.michel.gpsoftplan.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("v1/usuario")
public class UsuarioRestService {

    private final UsuarioService usuarioService;
    private final UsuarioDtoAssembler usuarioDtoAssembler;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UsuarioDto getById(@PathVariable Long id) {
        return usuarioDtoAssembler.toResource(usuarioService.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public UsuarioDto save(@RequestBody UsuarioDto usuarioDto) {
        return usuarioDtoAssembler.toResource(usuarioService.save(usuarioDtoAssembler.toDomain(usuarioDto)));
    }

}
