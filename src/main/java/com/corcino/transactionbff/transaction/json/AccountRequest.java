package com.corcino.transactionbff.transaction.json;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class AccountRequest {

    @Schema(description = "Account code")
    @NotNull(message = "Inform the account code")
    private Integer accountCode;

    @Schema(description = "Agency code")
    @NotNull(message = "Inform the agency code")
    private Integer agencyCode;

}
