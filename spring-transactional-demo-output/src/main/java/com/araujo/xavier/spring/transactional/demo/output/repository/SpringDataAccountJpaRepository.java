package com.araujo.xavier.spring.transactional.demo.output.repository;

import com.araujo.xavier.spring.transactional.demo.output.dbo.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAccountJpaRepository extends JpaRepository<AccountEntity, String> {
}
