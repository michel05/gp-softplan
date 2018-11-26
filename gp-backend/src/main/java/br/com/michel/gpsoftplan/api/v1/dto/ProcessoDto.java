package br.com.michel.gpsoftplan.api.v1.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Relation(value = "processo", collectionRelation = "processos")
public class ProcessoDto extends ResourceSupport {

    private Long cod;
    private String descricao;
    private List<UsuarioDto> finalizadores;
    private ParecerDto parecer;

}
