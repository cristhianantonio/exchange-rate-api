package com.bcp.pe.exchangerateapi.controller;

import com.bcp.pe.exchangerateapi.model.api.CurrencyRequest;
import com.bcp.pe.exchangerateapi.model.api.CurrencyResponse;
import com.bcp.pe.exchangerateapi.model.api.ExchangeRateRequest;
import com.bcp.pe.exchangerateapi.model.api.ExchangeRateResponse;
import com.bcp.pe.exchangerateapi.service.ExchangeRateService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rx.Single;

/**
 * Created with IntelliJ IDEA
 *
 * @author Cristhian
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
@RequestMapping(value = "v1/", produces = "application/json", consumes = "application/json")
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @PostMapping
    public Single<ExchangeRateResponse> currencyExchange(@Valid @RequestBody ExchangeRateRequest request) {
        log.info("init currencyExchange .....");
        return exchangeRateService.currencyExchange(request)
                .doOnError(e -> log.error("error: {}", e.getMessage()));
    }

    @PostMapping(value = "update")
    public Single<CurrencyResponse> updateCurrency(@Valid @RequestBody CurrencyRequest request) {
        log.info("init updateCurrency .....");
        return exchangeRateService.updateExchangeRate(request)
                .doOnError(e -> log.error("error: {}", e.getMessage()));
    }
}
