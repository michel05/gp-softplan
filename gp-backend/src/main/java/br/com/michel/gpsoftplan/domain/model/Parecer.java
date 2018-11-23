package br.com.michel.gpsoftplan.domain.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PARECER")
public class Parecer  extends PersistentObject {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proceder_id")
    private Processo processo;
}
