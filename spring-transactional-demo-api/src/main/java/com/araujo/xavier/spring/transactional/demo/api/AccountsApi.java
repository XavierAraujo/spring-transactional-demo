package com.araujo.xavier.spring.transactional.demo.api;

import com.araujo.xavier.spring.transactional.demo.core.driver.AccountServicePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Slf4j
@Controller
public class AccountsApi {

    private final AccountServicePort accountServicePort;

    public AccountsApi(AccountServicePort accountServicePort) {
        this.accountServicePort = accountServicePort;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/accounts/{accountId}"
    )
    public ResponseEntity<Void> createAccount(
            @PathVariable("accountId") String accountId,
            @RequestBody List<String> visitedCities
    ) {
        log.info("Creating account {} and associating it to cities: {}", accountId, visitedCities);
        accountServicePort.createAccount(accountId, visitedCities);
        return ResponseEntity.ok().build();
    }

}
