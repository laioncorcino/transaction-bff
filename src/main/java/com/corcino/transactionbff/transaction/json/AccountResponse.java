package com.corcino.transactionbff.transaction.json;

import com.corcino.transactionbff.transaction.model.Account;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class AccountResponse {

    @Schema(description = "Account code")
    private final Integer accountCode;

    @Schema(description = "Agency code")
    private final Integer agencyCode;

    public AccountResponse(Account account) {
        this.accountCode = account.getAccountCode();
        this.agencyCode = account.getAgencyCode();
    }
}
