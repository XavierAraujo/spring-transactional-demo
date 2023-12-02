package com.araujo.xavier.spring.transactional.demo.output.repository;

import com.araujo.xavier.spring.transactional.demo.output.dbo.VisitedCityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataVisitedCityJpaRepository extends JpaRepository<VisitedCityEntity, Long> {
}
