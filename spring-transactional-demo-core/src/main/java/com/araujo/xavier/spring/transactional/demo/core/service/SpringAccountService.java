package com.araujo.xavier.spring.transactional.demo.core.service;

import com.araujo.xavier.spring.transactional.demo.core.driven.AccountRepositoryPort;
import com.araujo.xavier.spring.transactional.demo.core.driver.AccountServicePort;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class SpringAccountService implements AccountServicePort {

    private final AccountRepositoryPort accountRepositoryPort;

    public SpringAccountService(AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Override
    @Transactional
    public void createAccount(String accountId, List<String> visitedCities) {
        accountRepositoryPort.createAccount(accountId);
        accountRepositoryPort.addVisitedCitiesToAccount(accountId, visitedCities);
        log.info("Finished creating account {}", accountId);
    }
}
