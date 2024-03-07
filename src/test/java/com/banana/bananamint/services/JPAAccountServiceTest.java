package com.banana.bananamint.services;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.exception.AccountException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;


import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class JPAAccountServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(JPAAccountServiceTest.class);


    @Autowired

    private JPAAccountService jpaService;

    @Test
    void given_an_acount_When_save_thenOK() throws AccountException {
        // given
        Customer customer = new Customer(1L);
        Account newAccount = new Account(null, "corriente", LocalDate.now(), 1000, 500, customer, true);

        // when
        jpaService.open(1L, newAccount);
        System.out.println(newAccount);

        // then
        assertThat(newAccount).isNotNull();
        assertThat(newAccount.getId()).isGreaterThan(0);
    }

}