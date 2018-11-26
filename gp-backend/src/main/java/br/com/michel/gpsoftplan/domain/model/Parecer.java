package br.com.michel.gpsoftplan.domain.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PARECER")
public class Parecer  extends PersistentObject {

    private String descricao;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proceder_id")
    private Processo processo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_finalizador_id")
    private Usuario usuarioFinalizador;
}
