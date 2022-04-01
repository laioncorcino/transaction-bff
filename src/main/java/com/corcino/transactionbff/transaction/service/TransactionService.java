package com.corcino.transactionbff.transaction.service;

import com.corcino.transactionbff.error.exception.NotFoundException;
import com.corcino.transactionbff.transaction.factory.TransactionFactory;
import com.corcino.transactionbff.transaction.json.TransactionRequest;
import com.corcino.transactionbff.transaction.json.TransactionResponse;
import com.corcino.transactionbff.transaction.model.Transaction;
import com.corcino.transactionbff.transaction.redis.RedisTransactionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class TransactionService {

    private RedisTransactionRepository redisRepository;
    private TransactionFactory transactionFactory;

    public TransactionResponse createTransaction(TransactionRequest transactionRequest) throws Exception {
        Transaction transaction = transactionFactory.buildModelTransaction(transactionRequest);
        Transaction transactionSaved = saveTransaction(transaction);
        return new TransactionResponse(transactionSaved);
    }

    private Transaction saveTransaction(Transaction transaction) throws Exception {
        try {
            log.info("Saving book");
            return redisRepository.save(transaction);
        } catch (Exception | Error e) {
            log.error("Erro ao salvar transação", e.getCause());
            throw new Exception(e.getCause());
        }
    }

    public TransactionResponse getTransactionById(String transactionId) {
        Transaction transaction = getTransaction(transactionId);
        return new TransactionResponse(transaction);
    }

    private Transaction getTransaction(String transactionId) {
        log.info("Buscando transação de id {}", transactionId);
        Optional<Transaction> transaction = redisRepository.findById(transactionId);

        return transaction.orElseThrow(() -> {
            log.error("Transação de id {} nao encontrado", transactionId);
            return new NotFoundException("Transaction not found");
        });
    }


}
