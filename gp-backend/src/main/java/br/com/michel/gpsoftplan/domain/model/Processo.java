package br.com.michel.gpsoftplan.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PROCESSO")
public class Processo  extends PersistentObject {

    private String descricao;

    @OneToMany
    private List<Usuario> usuarioPermitidos;

    @OneToOne(mappedBy = "processo", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Parecer parecer;
}
