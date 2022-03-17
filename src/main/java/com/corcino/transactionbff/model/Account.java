package com.corcino.transactionbff.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {

    private Integer accountCode;
    private Integer agencyCode;

}
