package com.banana.bananamint.services;

import com.banana.bananamint.domain.Expense;
import com.banana.bananamint.domain.Income;
import com.banana.bananamint.exception.IncomeExpenseException;
import com.banana.bananamint.payload.IncomeExpenseComparison;
import com.banana.bananamint.persistence.ExpenseJPARepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
public class JPAExpenseService implements IncomeExpenseService{
     private Logger logger = LoggerFactory.getLogger(JPAExpenseService.class);

    @Autowired
    private ExpenseJPARepository expenseRepository;

    @Override
    public List<Income> showAllIncomes(Long idCustomer) throws IncomeExpenseException {
        return null;
    }

    @Override
    public Income addIncome(Long idCustomer, Income income) throws IncomeExpenseException {
        return null;
    }

    @Override
    public List<Income> showAllExpenses(Long idCustomer) throws IncomeExpenseException {
        return null;
    }

    @Override
    public Expense addExpense(Long idCustomer, Expense expense) throws IncomeExpenseException {
        expense.setId(Math.toIntExact(idCustomer));
        return expenseRepository.save(expense);
    }

    @Override
    public List<Income> showAllExpensesByDateRange(Long idCustomer, LocalDate initDate, LocalDate finalDate) throws IncomeExpenseException {
        return null;
    }

    @Override
    public List<IncomeExpenseComparison> getFinancialPerspective(Long idCustomer, LocalDate initDate, LocalDate finalDate) throws IncomeExpenseException {
        return null;
    }
}