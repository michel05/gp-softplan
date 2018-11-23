package br.com.michel.gpsoftplan.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "PROCESSO")
public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @OneToMany
    private List<Usuario> usuarioPermitidos;

    @OneToOne(mappedBy = "processo", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Parecer parecer;
}
