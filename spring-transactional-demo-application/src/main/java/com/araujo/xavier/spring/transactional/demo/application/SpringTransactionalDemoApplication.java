package com.araujo.xavier.spring.transactional.demo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.araujo.xavier.spring.transactional.demo"})
public class SpringTransactionalDemoApplication {

    protected SpringTransactionalDemoApplication() { }

    public static void main(String[] args) {
        SpringApplication.run(SpringTransactionalDemoApplication.class, args);
    }

}
