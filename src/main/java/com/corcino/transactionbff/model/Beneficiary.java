package com.corcino.transactionbff.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Beneficiary {

    private String name;
    private String cnpj;
    private Long accountCode;
    private Long agencyCode;
    private String bank;

}
