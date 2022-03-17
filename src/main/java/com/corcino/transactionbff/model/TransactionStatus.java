package com.corcino.transactionbff.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public enum TransactionStatus {

    NAO_ANALISADA,
    EM_ANALISE_HUMANA,
    ANALISADA,
    EM_SUSPEITA_FRAUDE,
    RISCO_CONFIRMADO;

}
