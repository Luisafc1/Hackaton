package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@DataJpaTest()
@ComponentScan(basePackages = {"com.banana.bananamint.persistence"})
@AutoConfigureTestEntityManager
class AccountJPARepositoryTest {
private static final Logger logger = LoggerFactory.getLogger(AccountJPARepositoryTest.class);

    @Autowired
    private TestEntityManager entityManager;

    @Autowired

    private AccountJPARepository jpaRepo;

    @Test
    void given_an_acount_When_save_thenOK() {
        // given
        Customer customer = new Customer(1L);
        Account newAccount = new Account(null,"corriente", LocalDate.now(),1000,500,customer,true);
        // when
        newAccount = jpaRepo.save(newAccount);
        System.out.println("newAccount:" + newAccount);

        customer = entityManager.find(Customer.class,1L);
        System.out.println("customer:" + customer);

        // then
        assertThat(newAccount.getId()).isNotNull();
        assertThat(newAccount.getId().isGreaterThan(0));
    }

}