package com.araujo.xavier.spring.transactional.demo.output.adapter;

import com.araujo.xavier.spring.transactional.demo.core.driven.AccountRepositoryPort;
import com.araujo.xavier.spring.transactional.demo.output.dbo.AccountEntity;
import com.araujo.xavier.spring.transactional.demo.output.dbo.VisitedCityEntity;
import com.araujo.xavier.spring.transactional.demo.output.repository.SpringDataAccountJpaRepository;
import com.araujo.xavier.spring.transactional.demo.output.repository.SpringDataVisitedCityJpaRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

public class SpringDataAccountRepository implements AccountRepositoryPort {

    private final SpringDataAccountJpaRepository springDataAccountJpaRepository;

    private final SpringDataVisitedCityJpaRepository springDataVisitedCityJpaRepository;

    public SpringDataAccountRepository(SpringDataAccountJpaRepository springDataAccountJpaRepository,
                                       SpringDataVisitedCityJpaRepository springDataVisitedCityJpaRepository) {
        this.springDataAccountJpaRepository = springDataAccountJpaRepository;
        this.springDataVisitedCityJpaRepository = springDataVisitedCityJpaRepository;
    }

    @Override
    public void createAccount(String accountId) {
        springDataAccountJpaRepository.save(AccountEntity.builder().accountId(accountId).build());
    }

    @Override
    public void addVisitedCitiesToAccount(String accountId, List<String> visitedCities) {
        springDataVisitedCityJpaRepository.saveAll(
                visitedCities.stream()
                        .map(city -> VisitedCityEntity.builder().accountId(accountId).cityName(city).build())
                        .toList()
        );
    }
}
