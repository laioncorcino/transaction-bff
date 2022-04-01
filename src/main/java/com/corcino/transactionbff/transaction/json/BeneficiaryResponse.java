package com.corcino.transactionbff.transaction.json;

import com.corcino.transactionbff.transaction.model.Beneficiary;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class BeneficiaryResponse {

    @Schema(description = "Name of the beneficiary")
    private final String name;

    @Schema(description = "Cnpj of the beneficiary")
    private final String cnpj;

    @Schema(description = "Destination bank code")
    private final Long accountCode;

    @Schema(description = "Destination agency code")
    private final Long agencyCode;

    @Schema(description = "Destination bank name")
    private final String bank;

    public BeneficiaryResponse(Beneficiary beneficiary) {
        this.name = beneficiary.getName();
        this.cnpj = beneficiary.getCnpj();
        this.accountCode = beneficiary.getAccountCode();
        this.agencyCode = beneficiary.getAgencyCode();
        this.bank = beneficiary.getBank();
    }

}
