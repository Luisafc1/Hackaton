package com.banana.bananamint.services;

import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Goal;
import com.banana.bananamint.exception.AccountException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class JPAGoalServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(JPAGoalServiceTest.class);

    @Autowired

    private JPAGoalService jpaService;

    @Test
    void given_an_goal_When_save_thenOK() throws AccountException {
        // given
        Customer aCustomer = new Customer(1L);
        Goal aGoal = new Goal(2L,"Vacaciones", "Vacaciones24", 1000,"Activo",LocalDate.of(2024,10,12),aCustomer);

        // when
        jpaService.add(1L, aGoal);
        System.out.println(aGoal);

        // then
        assertThat(aGoal).isNotNull();
        assertThat(aGoal.getId()).isGreaterThan(0);
    }

}