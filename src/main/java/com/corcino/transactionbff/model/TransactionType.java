package com.corcino.transactionbff.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public enum TransactionType {

    PAGAMENTO_TRIBUTOS,
    PAGAMENTO_TITULOS,
    TED,
    DOC,
    PIX;

}
