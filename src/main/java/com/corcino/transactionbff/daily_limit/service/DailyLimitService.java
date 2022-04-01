package com.corcino.transactionbff.daily_limit.service;

import com.corcino.transactionbff.daily_limit.feign.DailyLimitClient;
import com.corcino.transactionbff.daily_limit.json.DailyLimitResponse;
import com.corcino.transactionbff.error.exception.ApiAccessException;
import com.corcino.transactionbff.error.exception.NotFoundException;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
@AllArgsConstructor
public class DailyLimitService {

    private DailyLimitClient limitClient;

    @CircuitBreaker(name = "CIRCUIT_BRAKER_DAILY_LIMIT", fallbackMethod = "fallbackLimitAgencyAndAccount")
    public DailyLimitResponse getLimitByAgencyAndAccount(Long agencyCode, Long accountCode) {
        try {
            return limitClient.getDailyLimitWithAgencyAndAccount(agencyCode, accountCode);
        }
        catch (FeignException e) {
            if (HttpStatus.NOT_FOUND.value() == e.status()) {
                log.error("Limite diario de agencia {} e conta {} nao encontrado", agencyCode, accountCode);
                throw new NotFoundException("Daily limit not found for this agency " + agencyCode + " and account " + accountCode);
            }

            log.error("Erro ao acessar limite diario");
            throw new ApiAccessException("Daily limit access error");
        }
        catch (Exception | Error e) {
            log.error("Erro de servidor ao acessar limite diario");
            throw new ApiAccessException("Daily limit access error");
        }
    }

    public DailyLimitResponse fallbackLimitAgencyAndAccount(Long agencyCode, Long accountCode, CallNotPermittedException e) {
        return new DailyLimitResponse(0L, 0L, 0L, BigDecimal.ZERO, BigDecimal.ZERO);
    }

}
