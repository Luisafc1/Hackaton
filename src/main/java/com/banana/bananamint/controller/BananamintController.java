package com.banana.bananamint.controller;

import com.banana.bananamint.domain.Expense;
import com.banana.bananamint.services.JPAExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;


@RestController
@RequestMapping("/Bananamint/expense")
@Validated
public class BananamintController {

    @Autowired
    private JPAExpenseService expenseService;

    @PostMapping("/{id}")
    public ResponseEntity<Expense> createGasto(
            @RequestBody @Valid Expense gasto,
            @PathVariable @Min(1) Long id
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(expenseService.addExpense(id,gasto));
    }
}
