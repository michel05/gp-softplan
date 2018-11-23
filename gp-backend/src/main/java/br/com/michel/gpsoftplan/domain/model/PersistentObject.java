package br.com.michel.gpsoftplan.domain.model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class PersistentObject {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


}
