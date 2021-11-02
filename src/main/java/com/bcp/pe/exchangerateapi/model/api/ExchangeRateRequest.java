package com.bcp.pe.exchangerateapi.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
public class ExchangeRateRequest implements Serializable {
    @DecimalMin(value = "1.0",message = "el campo monto no puede estar vacio")
    @JsonProperty("monto")
    private Double amount;
    @NotBlank(message = "el campo moneda Origen no puede estar vacio")
    @Size(min = 3,max = 3,message = "el campo moneda Origen es incorrecto. ejm: USD, PEN .. ")
    @JsonProperty("monedaOrigen")
    private String currencyOrigin;
    @NotBlank(message = "el campo moneda Destino no puede estar vacio")
    @Size(min = 3,max = 3,message = "el campo moneda Destino es incorrecto. ejm: USD, PEN .. ")
    @JsonProperty("monedaDestino")
    private String targetCurrency;
}
