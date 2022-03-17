package com.corcino.transactionbff.json;

import com.corcino.transactionbff.model.Transaction;
import com.corcino.transactionbff.model.TransactionStatus;
import com.corcino.transactionbff.model.TransactionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class TransactionResponse {

    @Schema(description = "Transaction identification code")
    private final UUID transactionId;

    @Schema(description = "Transaction amount")
    private final BigDecimal amount;

    @Schema(description = "Transaction source account")
    private final AccountResponse account;

    @Schema(description = "Transaction beneficiary")
    private final BeneficiaryResponse beneficiary;

    @Schema(description = "Transaction type")
    private final TransactionType type;

    @Schema(description = "Transaction status")
    private final TransactionStatus status;

    @Schema(description = "Transaction date hour minute")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private final LocalDateTime date;

    public TransactionResponse(Transaction transaction) {
        this.transactionId = transaction.getTransactionId();
        this.amount = transaction.getAmount();
        this.account = new AccountResponse(transaction.getAccount());
        this.beneficiary = new BeneficiaryResponse(transaction.getBeneficiary());
        this.type = transaction.getType();
        this.status = transaction.getStatus();
        this.date = transaction.getDate();
    }


}
