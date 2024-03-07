package com.banana.bananamint.controller;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Income;
import com.banana.bananamint.persistence.IncomeJPARepository;
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
    private BananamintController controller;

    @Test
    void givenIncomes_whenValidIncome_thenIsCreatedAndHaveId() {

        Customer customer = new Customer(1L);
        Account incomeAccount = new Account(1L);
        Income newIncome = new Income(null,customer,2000,LocalDate.now(),incomeAccount,"Nomina");

        ResponseEntity<Income> response = controller.createIncome(newIncome,1L, 1L);
        System.out.println("***** response:" + response);

        assertThat(response.getStatusCode().value()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getBody().getId()).isGreaterThan(0);

    }

}