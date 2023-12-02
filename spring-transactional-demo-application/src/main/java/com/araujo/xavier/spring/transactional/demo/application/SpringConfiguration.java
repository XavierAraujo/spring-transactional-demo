package com.araujo.xavier.spring.transactional.demo.application;

import com.araujo.xavier.spring.transactional.demo.core.driven.AccountRepositoryPort;
import com.araujo.xavier.spring.transactional.demo.core.driver.AccountServicePort;
import com.araujo.xavier.spring.transactional.demo.core.service.SpringAccountService;
import com.araujo.xavier.spring.transactional.demo.output.adapter.SpringDataAccountRepository;
import com.araujo.xavier.spring.transactional.demo.output.repository.SpringDataAccountJpaRepository;
import com.araujo.xavier.spring.transactional.demo.output.repository.SpringDataVisitedCityJpaRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.araujo.xavier.spring.transactional.demo.output.repository")
@EntityScan(basePackages = "com.araujo.xavier.spring.transactional.demo.output.dbo")
public class SpringConfiguration {

    @Bean
    public AccountServicePort accountServicePort(AccountRepositoryPort accountRepositoryPort) {
        return new SpringAccountService(accountRepositoryPort);
    }

    @Bean
    public AccountRepositoryPort accountRepositoryPort(SpringDataAccountJpaRepository springDataAccountJpaRepository,
                                                       SpringDataVisitedCityJpaRepository springDataVisitedCityJpaRepository) {
        return new SpringDataAccountRepository(springDataAccountJpaRepository, springDataVisitedCityJpaRepository);
    }


}
