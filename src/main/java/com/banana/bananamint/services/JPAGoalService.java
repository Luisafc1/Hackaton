package com.banana.bananamint.services;

import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Goal;
import com.banana.bananamint.exception.GoalException;
import com.banana.bananamint.payload.Debt;
import com.banana.bananamint.payload.GoalApproximation;
import com.banana.bananamint.persistence.GoalJPARepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

@Service
public class JPAGoalService implements GoalService {

    private Logger logger = LoggerFactory.getLogger((GoalService.class));
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private GoalJPARepository goalRepo;

    @Override
    public List<Goal> showAll(Long idCustomer) throws GoalException {
        return null;

    }

    @Override
    public List<Goal> add(Long idCustomer, Goal goal) throws GoalException {
        return null;
    }

    @Override
    public Goal addGoal(Long idCustomer, Goal goal) throws GoalException {
        Customer customer = entityManager.find(Customer.class,idCustomer);
        goal.setUser(customer);
        goal.setTargetDate(LocalDate.now());
        return goalRepo.save(goal);
    }

    @Override
    public List<GoalApproximation> generateReport(Long idCustomer, LocalDate initDate, LocalDate finalDate) throws GoalException {
        return null;
    }

    @Override
    public List<Debt> accumulatedDebt(Long idCustomer, LocalDate initDate, LocalDate finalDate) throws GoalException {
        return null;
    }
}
