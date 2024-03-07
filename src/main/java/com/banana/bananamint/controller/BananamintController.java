package com.banana.bananamint.controller;

import com.banana.bananamint.domain.Expense;
import com.banana.bananamint.services.JPAExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;


@RestController
@RequestMapping("/Bananamint/expense")
@Validated
public class BananamintController {

    @Autowired
    private JPAExpenseService expenseService;

    @Operation(summary = "Add a new expense", description = "Returns a persisted product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Successfully created"),
            @ApiResponse(responseCode = "4XX", description = "Bad request")
    })
    @PostMapping("/{id}/{aid}")
    public ResponseEntity<Expense> createGasto(
            @RequestBody @Valid Expense gasto,
            @PathVariable @Min(1) Long id,
            @PathVariable @Min(1) Long aid
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(expenseService.addExpense(id,aid,gasto));
    }
}
