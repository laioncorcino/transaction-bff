package com.corcino.transactionbff.factory;

import com.corcino.transactionbff.json.AccountRequest;
import com.corcino.transactionbff.json.BeneficiaryRequest;
import com.corcino.transactionbff.json.TransactionRequest;
import com.corcino.transactionbff.model.Account;
import com.corcino.transactionbff.model.Beneficiary;
import com.corcino.transactionbff.model.Transaction;
import com.corcino.transactionbff.model.TransactionStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransactionFactory {

    public Transaction buildModelTransaction(TransactionRequest transactionRequest) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setAccount(buildModelAccount(transactionRequest.getAccount()));
        transaction.setBeneficiary(buildModelBeneficiary(transactionRequest.getBeneficiary()));
        transaction.setType(transactionRequest.getType());
        transaction.setStatus(TransactionStatus.NAO_ANALISADA);
        transaction.setDate(LocalDateTime.now());

        return transaction;
    }

    private Account buildModelAccount(AccountRequest request) {
        return new Account(request.getAccountCode(), request.getAgencyCode());
    }

    private Beneficiary buildModelBeneficiary(BeneficiaryRequest request) {
        return new Beneficiary(request.getName(), request.getCnpj(), request.getAccountCode(), request.getAgencyCode(), request.getBank());
    }

}
