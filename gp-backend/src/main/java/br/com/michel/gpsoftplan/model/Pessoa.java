package br.com.michel.gpsoftplan.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String nome;
}
