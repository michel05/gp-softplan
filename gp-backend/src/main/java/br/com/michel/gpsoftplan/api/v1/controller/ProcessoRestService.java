package br.com.michel.gpsoftplan.api.v1.controller;

import br.com.michel.gpsoftplan.api.v1.dto.ProcessoDto;
import br.com.michel.gpsoftplan.api.v1.dto.ProcessoDtoAssembler;
import br.com.michel.gpsoftplan.domain.model.PersistentObject;
import br.com.michel.gpsoftplan.domain.model.Processo;
import br.com.michel.gpsoftplan.service.ProcessoService;
import br.com.michel.gpsoftplan.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("v1/processo")
public class ProcessoRestService {

    private final ProcessoService processoService;
    private final UserDetailsService userDetailsService;
    private final ProcessoDtoAssembler processoDtoAssembler;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public List<ProcessoDto> getAll() {
        List<Processo> processos = new ArrayList<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authentication.getName());
        if(userDetails.getAuthorities().stream().anyMatch( x -> ((GrantedAuthority) x).getAuthority().equals("USER_TRIADOR"))) {
            processos = processoService.findAll();
        } else if(userDetails.getAuthorities().stream().anyMatch( x -> ((GrantedAuthority) x).getAuthority().equals("USER_FINALIZADOR"))) {
            processos = processoService.findAllPedenteParecer(userDetails.getUsername());
        }
        return processoDtoAssembler.toResource(processos);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProcessoDto getById(@PathVariable Long id) {
        return processoDtoAssembler.toResource(processoService.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProcessoDto save(@RequestBody ProcessoDto processoDto) {
        System.out.println(processoDto.toString());
        return processoDtoAssembler.toResource(processoService.save(processoDtoAssembler.toDomain(processoDto)));
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        processoService.delete(id);
    }

}
