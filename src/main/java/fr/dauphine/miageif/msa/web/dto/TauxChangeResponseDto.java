package fr.dauphine.miageif.msa.web.dto;

import fr.dauphine.miageif.msa.domain.model.CurrencyModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TauxChangeResponseDto {
    private Long id;

    private String source;

    private String dest;

    private BigDecimal rate;

    private Date dateExchange;
}
