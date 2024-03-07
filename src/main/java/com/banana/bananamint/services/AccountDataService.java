package com.banana.bananamint.services;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.exception.AccountException;
import com.banana.bananamint.persistence.AccountJPARepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.time.LocalDate;
import java.util.List;


@Service
public class AccountDataService implements AccountService{
    private Logger logger = LoggerFactory.getLogger(AccountService.class);
    @Autowired
    private AccountJPARepository accountRepository;

    @Override
    public List<Account> showAll(Long idCustomer) throws AccountException {
        return null;
    }
    @Override
    public Account open(Long idCustomer, Account account) throws AccountException {
        Customer customer = new Customer(idCustomer);//entityManager.find(Customer.class,idCustomer);
        System.out.println("customer:" + customer);
        account.setOwner(customer);
        account.setOpeningDate(LocalDate.now());
        return accountRepository.save(account);
    }
}
