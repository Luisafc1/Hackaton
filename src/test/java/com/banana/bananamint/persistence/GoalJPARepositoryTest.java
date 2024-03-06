package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Goal;
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

class GoalJPARepositoryTest {
private static final Logger logger = LoggerFactory.getLogger(GoalJPARepositoryTest.class);

    @Autowired
    private TestEntityManager entityManager;

    @Autowired

    private GoalJPARepository jpaRepo;

    @Test
    void save() {
        // given
        Customer aCustomer = new Customer(null, "Alex Perez","alex@bananamint.com",LocalDate.of(1985,03,06),"12345678L");
        Goal aGoal = new Goal(null,"Vacaciones", "Vacaciones24", 1000,"Activo",LocalDate.of(2024,10,12),aCustomer);

        // when
        jpaRepo.save(aGoal);

        System.out.println(aGoal);

        // then
        assertThat(aGoal.getId()).isGreaterThan(0);
    }


}