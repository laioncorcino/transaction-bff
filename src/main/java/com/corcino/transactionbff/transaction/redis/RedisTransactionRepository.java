package com.corcino.transactionbff.transaction.redis;

import com.corcino.transactionbff.transaction.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisTransactionRepository extends CrudRepository<Transaction, String> {

}
