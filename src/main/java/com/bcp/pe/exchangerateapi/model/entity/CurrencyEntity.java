package com.bcp.pe.exchangerateapi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA
 *
 * @author Cristhian
 */
@Getter
@Setter
@ToString
@Table(name = "MONEDA")
@Entity
public class CurrencyEntity {
    @Id
    @Column(name = "ID_MONEDA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurrency;

    @Column(name = "MONEDA_ORIGEN")
    private String currencyOrigin;

    @Column(name = "MONEDA_DESTINO")
    private String targetCurrency;

    @Column(name = "VALOR_APLICADO")
    private Double appliedValue;

    @Column(name = "TIPO_CAMBIO")
    private Double exchangeRate;

}
