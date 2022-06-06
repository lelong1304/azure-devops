package fr.dauphine.miageif.msa.domain.model;

import lombok.Data;

import javax.persistence.Column;
@Data
public class CurrencyModel {
    private Long id;
    private String symbol;
    private String description;
}
