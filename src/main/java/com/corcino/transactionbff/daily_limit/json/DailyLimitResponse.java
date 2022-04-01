package com.corcino.transactionbff.daily_limit.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DailyLimitResponse {

    private Long dailyLimitId;
    private Long agencyCode;
    private Long accountCode;
    private BigDecimal balance;
    private BigDecimal limitValue;

}
