package com.bcp.pe.exchangerateapi.model.api;

import java.io.Serializable;
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
public class CurrencyResponse implements Serializable {
    private Integer idCurrency;
    private String currencyOrigin;
    private String targetCurrency;
    private Double appliedValue;
    private Double exchangeRate;
}
