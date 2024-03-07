package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Goal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest()
@ComponentScan(basePackages = {"com.banana.bananamint.persistence"})
@AutoConfigureTestEntityManager
class GoalJPARepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired

    private GoalJPARepository jpaRepo;

    @Test
    void given_a_goal_When_save_thenOK() {
        // given
        Customer customer = new Customer(1L);
        Goal newGoal = new Goal(null,"Ahorro","200 EUR mes",200,"iniciado", LocalDate.now(),customer);
        // when
        newGoal= jpaRepo.save(newGoal);
        System.out.println("newGoal:" + newGoal);

        customer = entityManager.find(Customer.class, 1L);
        System.out.println("customer:" + customer);

        // then
        assertThat(newGoal).isNotNull();
        assertThat(newGoal.getId()).isGreaterThan(0);
    }

}