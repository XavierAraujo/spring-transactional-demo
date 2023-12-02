package com.araujo.xavier.spring.transactional.demo.core.driven;

import java.util.List;

public interface AccountRepositoryPort {

    void createAccount(String accountId);

    void addVisitedCitiesToAccount(String accountId, List<String> visitedCities);

}
