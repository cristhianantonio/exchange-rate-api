package com.bcp.pe.exchangerateapi.service.mapper;

import com.bcp.pe.exchangerateapi.model.api.CurrencyResponse;
import com.bcp.pe.exchangerateapi.model.api.ExchangeRateRequest;
import com.bcp.pe.exchangerateapi.model.api.ExchangeRateResponse;
import com.bcp.pe.exchangerateapi.model.entity.CurrencyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created with IntelliJ IDEA
 *
 * @author Cristhian
 */
@Mapper(componentModel = "spring")
public interface ExchangeRateMapper {

    @Mapping(source = "rq.amount", target = "amount")
    @Mapping(source = "amountP", target = "amountWithExchangeRate")
    @Mapping(source = "rq.currencyOrigin", target = "currencyOrigin")
    @Mapping(source = "rq.targetCurrency", target = "targetCurrency")
    @Mapping(source = "db.exchangeRate", target = "exchangeRate")
    @Mapping(source = "db.appliedValue", target = "exchangeRateOrigin")
    ExchangeRateResponse toCurrencyChangeResponse(CurrencyEntity db,
                                                  ExchangeRateRequest rq,
                                                  Double amountP);

    CurrencyResponse toCurrencyResponse(CurrencyEntity db);
}
