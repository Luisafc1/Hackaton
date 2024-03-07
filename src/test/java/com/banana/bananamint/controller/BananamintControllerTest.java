package com.banana.bananamint.controller;

import com.banana.bananamint.domain.Goal;
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
    private BananamintController controller;

    @Test
    void givenCustomer_whenValidGoal_thenIsCreateGoal() {

        Customer aCustomer = new Customer(1L);
        Goal aGoal = new Goal(2L,"Vacaciones", "Vacaciones24", 1000,"Activo",LocalDate.of(2024,10,12),aCustomer);

        ResponseEntity<Goal> response = controller.addGoal(aGoal,2L);
        System.out.println("***** response:" + response);

        assertThat(response.getStatusCode().value()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getBody().getId()).isGreaterThan(0);

    }

}