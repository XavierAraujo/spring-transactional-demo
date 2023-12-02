package com.araujo.xavier.spring.transactional.demo.core.driver;


import java.util.List;

public interface AccountServicePort {

    void createAccount(String accountId, List<String> visitedCities);

}
