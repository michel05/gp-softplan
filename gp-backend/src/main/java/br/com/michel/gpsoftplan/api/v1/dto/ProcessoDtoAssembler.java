package br.com.michel.gpsoftplan.api.v1.dto;

import br.com.michel.gpsoftplan.domain.model.Parecer;
import br.com.michel.gpsoftplan.domain.model.Processo;
import br.com.michel.gpsoftplan.domain.model.Usuario;
import br.com.michel.gpsoftplan.service.ProcessoService;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProcessoDtoAssembler extends ResourceAssemblerSupport<Processo, ProcessoDto> {

    private UsuarioDtoAssembler usuarioDtoAssembler = new UsuarioDtoAssembler();

    public ProcessoDtoAssembler() {
        super(ProcessoService.class, ProcessoDto.class);
    }

    @Override
    public ProcessoDto toResource(Processo processo) {
        ProcessoDto processoDto = createResourceWithId(processo.getId(), processo);
        processoDto.setCod(processo.getId());
        processoDto.setDescricao(processo.getDescricao());
        processoDto.setFinalizadores(processo.getUsuarios() != null ? usuarioDtoAssembler.toResource(processo.getUsuarios()) : null);
        return processoDto;
    }

    public List<ProcessoDto> toResource(List<Processo> processos) {
        List<ProcessoDto> processoDtos = new ArrayList<>();
        processos.forEach(x -> processoDtos.add(toResource(x)));
        return processoDtos;
    }

    public Processo toDomain(ProcessoDto processoDto) {
        Processo processo = new Processo();
        processo.setDescricao(processoDto.getDescricao());
        if(processoDto.getCod() != null) {
            processo.setId(processoDto.getCod());
        }
        if (processoDto.getParecer() != null) {
            processo.setParecer(new Parecer(processoDto.getParecer().getDescricao(),
                                processo,
                                new Usuario(processoDto.getParecer().getUsuarioFinalizador().getCod())));
        }

        List<UsuarioDto> finalizadores = processoDto.getFinalizadores();
        if (finalizadores != null && !finalizadores.isEmpty()) {
            List<Usuario> usuarios = new ArrayList<>();
            for (UsuarioDto usuarioDto : finalizadores) {
                usuarios.add(new Usuario(usuarioDto.getCod()));
            }
            processo.setUsuarios(usuarios);
        }

        return processo;
    }

}
