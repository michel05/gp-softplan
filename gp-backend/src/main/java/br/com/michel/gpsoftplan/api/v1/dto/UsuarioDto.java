package br.com.michel.gpsoftplan.api.v1.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

@Data
@EqualsAndHashCode(callSuper = true)
@Relation(value = "usuario", collectionRelation = "usuarios")
public class UsuarioDto extends ResourceSupport {

    private String nome;
    private String usuario;

}
