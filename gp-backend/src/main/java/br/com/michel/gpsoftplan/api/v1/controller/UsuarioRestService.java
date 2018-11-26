package br.com.michel.gpsoftplan.api.v1.controller;

import br.com.michel.gpsoftplan.api.v1.dto.UsuarioDto;
import br.com.michel.gpsoftplan.api.v1.dto.UsuarioDtoAssembler;
import br.com.michel.gpsoftplan.service.UsuarioPerfilService;
import br.com.michel.gpsoftplan.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("v1")
public class UsuarioRestService {

    private final UsuarioService usuarioService;
    private final UsuarioPerfilService usuarioPerfilService;
    private final UsuarioDtoAssembler usuarioDtoAssembler;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public List<UsuarioDto> getAll() {
        return usuarioDtoAssembler.toResource(usuarioService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/finalizadores", method = RequestMethod.GET)
    public List<UsuarioDto> getFinalizadores() {
        return usuarioDtoAssembler.toResource(usuarioService.findAllByPerfil("USER_FINALIZADOR"));
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    public UsuarioDto getById(@PathVariable Long id) {
        return usuarioDtoAssembler.toResource(usuarioService.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/usuario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDto save(@RequestBody UsuarioDto usuarioDto) {
        System.out.println(usuarioDto.toString());
        return usuarioDtoAssembler.toResource(usuarioService.save(usuarioDtoAssembler.toDomain(usuarioDto)));
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        usuarioService.delete(id);
    }

}
