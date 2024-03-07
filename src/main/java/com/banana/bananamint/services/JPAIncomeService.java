package com.banana.bananamint.services;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Expense;
import com.banana.bananamint.domain.Income;
import com.banana.bananamint.exception.IncomeExpenseException;
import com.banana.bananamint.payload.IncomeExpenseComparison;
import com.banana.bananamint.persistence.IncomeJPARepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

@Service
public class JPAIncomeService implements IncomeExpenseService {

    private Logger logger = LoggerFactory.getLogger(JPAIncomeService.class);

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private IncomeJPARepository incomeRepository;

    @Override
    public List<Income> showAllIncomes(Long idCustomer) throws IncomeExpenseException {
        return incomeRepository.findAll();
    }

    @Override
    public Income addIncome(Long idCustomer, Long idAccount, Income income) throws IncomeExpenseException {
        Customer customer = entityManager.find(Customer.class, idCustomer);
        Account incomeAccount = entityManager.find(Account.class, idAccount);
        income.setMoneyTo(incomeAccount);
        income.setEnterDate(LocalDate.now());
        income.setUser(customer);

        return incomeRepository.save(income);
    }

    @Override
    public List<Income> showAllExpenses(Long idCustomer) throws IncomeExpenseException {
        return null;
    }

    @Override
    public Expense addExpense(Long idCustomer, Expense expense) throws IncomeExpenseException {
        return null;
    }

    @Override
    public List<Expense> showAllExpensesByDateRange(Long idCustomer, LocalDate initDate, LocalDate finalDate) throws IncomeExpenseException {
        return null;
    }

    @Override
    public List<IncomeExpenseComparison> getFinancialPerspective(Long idCustomer, LocalDate initDate, LocalDate finalDate) throws IncomeExpenseException {
        return null;
    }
}
