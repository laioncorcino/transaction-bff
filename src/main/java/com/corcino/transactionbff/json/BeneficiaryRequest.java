package com.corcino.transactionbff.json;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class BeneficiaryRequest {

    @Schema(description = "Name of the beneficiary")
    @NotNull(message = "Inform the name")
    private String name;

    @Schema(description = "Cpf of the beneficiary")
    @NotNull(message = "Inform the cnpj")
    private String cnpj;

    @Schema(description = "Destination bank code")
    @NotNull(message = "Inform the bank code")
    private Long accountCode;

    @Schema(description = "Destination agency code")
    @NotNull(message = "Inform the agency")
    private Long agencyCode;

    @Schema(description = "Destination bank name")
    @NotNull(message = "Inform the bank name")
    private String bank;

}
