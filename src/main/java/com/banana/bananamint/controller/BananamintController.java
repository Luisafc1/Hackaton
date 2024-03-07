package com.banana.bananamint.controller;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Expense;
import com.banana.bananamint.domain.Goal;
import com.banana.bananamint.domain.Income;
import com.banana.bananamint.services.AccountService;
import com.banana.bananamint.services.GoalService;
import com.banana.bananamint.services.IncomeExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/bananamint")
@Validated
@Tag(name = "Personal Finance Service", description = "Clients Finance management API")
public class BananamintController {

    @Autowired
    private IncomeExpenseService inExService;

    @Operation(summary = "Create a income ", description = "Create a new income")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created"),
            @ApiResponse(responseCode = "4**", description = "Bad Request")
    })
    @PostMapping("/income/{cid}/{aid}")
    public ResponseEntity<Income> createIncome(
            @RequestBody @Valid Income income, @PathVariable @Min(1) Long cid, @PathVariable @Min(1) Long aid
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body((Income) inExService.addIncome(cid, aid, income));
    }

}
