package com.banana.bananamint.service;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Goal;
import com.banana.bananamint.domain.Income;
import com.banana.bananamint.exception.AccountException;
import com.banana.bananamint.services.JPAIncomeService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;


import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class JPAIncomeServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(JPAIncomeService.class);

    @Autowired
    private JPAIncomeService jpaIncService;

    @Test
    void given_an_income_When_save_thenOK() throws AccountException {
        // given
        Customer customer = new Customer(1L);
        Account incomeAccount = new Account(1L);
        Income newIncome = new Income(null, customer, 2000, LocalDate.now(), incomeAccount, "Nomina");
        // when
        jpaIncService.addIncome(1L, 1L, newIncome);
        System.out.println(newIncome);

        // then
        assertThat(newIncome).isNotNull();
        assertThat(newIncome.getId()).isGreaterThan(0);
    }
}