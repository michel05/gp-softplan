package br.com.michel.gpsoftplan.api.v1.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Relation(value = "usuarioPerfil", collectionRelation = "usuarioPerfis")
public class UsuarioPerfilDto extends ResourceSupport {

    private Long cod;
    private String descricao;

}
