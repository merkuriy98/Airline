package com.merkulov.airline.repository.transaction;

public interface TransactionManager {

    <T> T transaction(TransactionMethod<T> transactionMethod);
}
