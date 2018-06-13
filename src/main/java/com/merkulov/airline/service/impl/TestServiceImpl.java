package com.merkulov.airline.service.impl;

import com.merkulov.airline.entity.Test;
import com.merkulov.airline.entity.User;
import com.merkulov.airline.repository.TestRepository;
import com.merkulov.airline.repository.transaction.TransactionManager;
import com.merkulov.airline.service.TestService;

public class TestServiceImpl implements TestService {
    private TransactionManager transactionManager;
    private TestRepository testRepository;

    public TestServiceImpl(TransactionManager transactionManager, TestRepository testRepository) {
        this.transactionManager = transactionManager;
        this.testRepository = testRepository;
    }

    @Override
    public Test getFirstTest() {
        return transactionManager.transaction(
                connection ->
                        testRepository.getFirstTest(connection));
    }

}
