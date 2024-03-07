package com.banana.bananamint.controller;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class BananamintControllerTest {

    @Autowired
    private AccountController controller;

    @Test
    void givenaccounts_whenVaildOpenAccount_thenIsCreatedAndHaveId() {

        Customer customer = new Customer(1L);
        Account newAccount = new Account(null, "corriente", LocalDate.now(), 1000, 500, customer, true);

        ResponseEntity<Account> response = controller.createAccount(newAccount,1L);
        System.out.println("***** response:" + response);

        assertThat(response.getStatusCode().value()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getBody().getId()).isGreaterThan(0);

    }

}