package com.bcp.pe.exchangerateapi.service;

import com.bcp.pe.exchangerateapi.model.api.CurrencyRequest;
import com.bcp.pe.exchangerateapi.model.api.CurrencyResponse;
import com.bcp.pe.exchangerateapi.model.api.ExchangeRateRequest;
import com.bcp.pe.exchangerateapi.model.api.ExchangeRateResponse;
import rx.Single;

/**
 * Created with IntelliJ IDEA
 *
 * @author Cristhian
 */
public interface ExchangeRateService {

    Single<ExchangeRateResponse> currencyExchange(ExchangeRateRequest request);

    Single<CurrencyResponse> updateExchangeRate(CurrencyRequest request);
}
