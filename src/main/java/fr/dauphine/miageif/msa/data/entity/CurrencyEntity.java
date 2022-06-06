package fr.dauphine.miageif.msa.data.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "currency")
@Entity
@Data
public class CurrencyEntity {
    @Id
    @GeneratedValue(generator = "currency_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "description")
    private String description;


}
