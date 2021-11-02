package com.bcp.pe.exchangerateapi.service.impl;

import com.bcp.pe.exchangerateapi.model.api.CurrencyRequest;
import com.bcp.pe.exchangerateapi.model.api.CurrencyResponse;
import com.bcp.pe.exchangerateapi.model.api.ExchangeRateRequest;
import com.bcp.pe.exchangerateapi.model.api.ExchangeRateResponse;
import com.bcp.pe.exchangerateapi.model.entity.CurrencyEntity;
import com.bcp.pe.exchangerateapi.repository.CurrencyRepository;
import com.bcp.pe.exchangerateapi.service.ExchangeRateService;
import com.bcp.pe.exchangerateapi.service.mapper.ExchangeRateMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BiFunction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rx.Single;

/**
 * Created with IntelliJ IDEA
 *
 * @author Cristhian
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ExchangeRateImpl implements ExchangeRateService {

    private final CurrencyRepository currencyRepository;
    private final ExchangeRateMapper currencyChangeMapper;

    @Override
    public Single<ExchangeRateResponse> currencyExchange(ExchangeRateRequest request) {
        return Single.just(request)
                .map(x -> getCurrency(x))
                .map(db -> currencyChangeMapper.toCurrencyChangeResponse(db,
                        request, convertAmount.apply(request, db)));
    }

    @Override
    public Single<CurrencyResponse> updateExchangeRate(CurrencyRequest request) {
        return Single.just(currencyRepository.findById(request.getIdCurrency())
                        .orElseThrow(() -> new IllegalStateException("Registro no encontrado")))
                .map(db -> {
                    db.setAppliedValue(request.getExchangeRateOrigin());
                    db.setExchangeRate(request.getExchangeRateDestination());
                    return currencyRepository.save(db);
                })
                .map(currencyChangeMapper::toCurrencyResponse);

    }

    private CurrencyEntity getCurrency(ExchangeRateRequest rq) {
        log.info("call db ....");
        return currencyRepository.findCurrencyEntityByCurrencyType(rq.getCurrencyOrigin(), rq.getTargetCurrency())
                .orElseThrow(() -> new IllegalStateException("TIPO DE CAMBIO NO ENCONTRADO"));
    }

    private final BiFunction<ExchangeRateRequest, CurrencyEntity, Double> convertAmount = (rq, db)
            -> rq.getAmount() * db.getAppliedValue();

}
