package com.bcp.pe.exchangerateapi.model.api;

import java.io.Serializable;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
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
public class CurrencyRequest implements Serializable {
    @Min(value = 1,message = "Ingresar Id")
    private Integer idCurrency;

    private Double exchangeRateOrigin;

    private Double exchangeRateDestination;
}
