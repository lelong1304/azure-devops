package fr.dauphine.miageif.msa.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class TauxChangeModel {
    private Long id;

    private CurrencyModel source;

    private CurrencyModel dest;

    private BigDecimal rate;

    private Date dateExchange;
}
