package br.com.michel.gpsoftplan.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "PARECER")
public class Parecer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proceder_id")
    private Processo processo;
}
