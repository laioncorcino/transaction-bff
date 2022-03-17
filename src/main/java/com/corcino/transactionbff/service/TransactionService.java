package com.corcino.transactionbff.service;

import com.corcino.transactionbff.factory.TransactionFactory;
import com.corcino.transactionbff.json.TransactionRequest;
import com.corcino.transactionbff.json.TransactionResponse;
import com.corcino.transactionbff.model.Transaction;
import com.corcino.transactionbff.redis.RedisTransactionRepository;
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
            return new RuntimeException("Book not found");
        });
    }


}
