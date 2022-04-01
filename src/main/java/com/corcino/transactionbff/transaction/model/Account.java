package com.corcino.transactionbff.transaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Account {

    private Integer accountCode;
    private Integer agencyCode;

}
