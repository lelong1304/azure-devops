package fr.dauphine.miageif.msa.data.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;


// Classe persistente representant  un "taux de change"
@Entity
@Table(name= "exchange_rate")
@Data
public class TauxChangeEntity {

    @Id
    @GeneratedValue(generator = "exchange_rate_id_seq")
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "src")
    private CurrencyEntity source;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dest")
    private CurrencyEntity dest;

    @Column(name = "rate")
    private BigDecimal rate;

    @Column(name = "date_exchange")
    private Date dateExchange;

}