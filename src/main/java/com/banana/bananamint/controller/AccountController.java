package com.banana.bananamint.controller;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.services.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/bananamint/account")
@Validated
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Operation(summary = "Add a new account", description = "Returns a persisted account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created"),
            @ApiResponse(responseCode = "4XX", description = "Bad request")
    })
    @PostMapping("/{cid}")
    public ResponseEntity<Account> createAccount(
            @RequestBody @Valid Account account, @PathVariable @Min(1) Long cid
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.open(cid, account));
    }
}
