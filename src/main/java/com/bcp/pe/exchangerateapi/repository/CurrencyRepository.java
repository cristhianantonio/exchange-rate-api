package com.bcp.pe.exchangerateapi.repository;

import com.bcp.pe.exchangerateapi.model.entity.CurrencyEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA
 *
 * @author Cristhian
 */
@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Integer> {
    @Query("SELECT C FROM CurrencyEntity C WHERE C.currencyOrigin = upper(?1)   and C.targetCurrency =upper(?2)")
    Optional<CurrencyEntity> findCurrencyEntityByCurrencyType(String currencyOrigin, String targetCurrency);
}
