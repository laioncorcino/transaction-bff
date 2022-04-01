package com.corcino.transactionbff.transaction.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@RedisHash(value = "Transaction", timeToLive = 180)
public class Transaction {

    @Id
    private UUID transactionId;
    private BigDecimal amount;
    private Account account;
    private Beneficiary beneficiary;
    private TransactionType type;
    private TransactionStatus status;
    private LocalDateTime date;

}
