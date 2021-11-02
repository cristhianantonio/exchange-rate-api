package com.bcp.pe.exchangerateapi.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ExchangeRateResponse implements Serializable {
    @JsonProperty("monto")
    private Double amount;
    @JsonProperty("montoConTipoCambio")
    private Double amountWithExchangeRate;
    @JsonProperty("monedaOrigen")
    private String currencyOrigin;
    @JsonProperty("monedaDestino")
    private String targetCurrency;
    @JsonProperty("TipoCambioOrigen")
    private Double exchangeRateOrigin;
    @JsonProperty("TipoCambioDestino")
    private Double exchangeRate;
}
