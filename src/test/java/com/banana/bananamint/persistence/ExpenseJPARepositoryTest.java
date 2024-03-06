package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Expense;
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
class ExpenseJPARepositoryTest {
private static final Logger logger = LoggerFactory.getLogger(ExpenseJPARepositoryTest.class);

    @Autowired
    private TestEntityManager entityManager;

    @Autowired

    private ExpenseJPARepository jpaRepo;

    @Test
    void save() {
        // given
        Expense aExpense = new Expense(null,null,12.3,LocalDate.now(),null,"true");

        // when
        jpaRepo.save(aExpense);

        System.out.println(aExpense);

        // then
        assertThat(aExpense.getId()).isGreaterThan(0);
    }

}