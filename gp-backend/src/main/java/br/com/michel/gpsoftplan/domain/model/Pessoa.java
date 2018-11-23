package br.com.michel.gpsoftplan.domain.model;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Pessoa extends PersistentObject {

    private String nome;
}
