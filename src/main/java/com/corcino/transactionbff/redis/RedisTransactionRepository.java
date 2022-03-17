package com.corcino.transactionbff.redis;

import com.corcino.transactionbff.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisTransactionRepository extends CrudRepository<Transaction, String> {

}
