package com.corcino.transactionbff.json;

import com.corcino.transactionbff.model.TransactionType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
public class TransactionRequest {

    @Schema(description = "Transaction amount")
    @NotNull(message = "Inform the transaction amount")
    private BigDecimal amount;

    @Schema(description = "Transaction source account")
    @NotNull(message = "Inform the transaction source account")
    @Valid
    private AccountRequest account;

    @Schema(description = "Transaction beneficiary")
    @NotNull(message = "Inform the transaction beneficiary")
    @Valid
    private BeneficiaryRequest beneficiary;

    @Schema(description = "Transaction type")
    @NotNull(message = "Inform the transaction type")
    private TransactionType type;

}
