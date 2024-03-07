package com.banana.bananamint.controller;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Expense;
import com.banana.bananamint.domain.Goal;
import com.banana.bananamint.domain.Income;
import com.banana.bananamint.services.AccountService;
import com.banana.bananamint.services.GoalService;
import com.banana.bananamint.services.IncomeExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/bananamint")
@Validated
public class BananamintController {


    @Autowired
    private GoalService goalService;


    @PostMapping("/goal/{cid}")
    public ResponseEntity<Goal> addGoal(
            @RequestBody @Valid Goal goal, @PathVariable @Min(1) Long cid
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body((Goal) goalService.addGoal(cid, goal));
    }

}
