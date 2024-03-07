package com.banana.bananamint.controller;
import com.banana.bananamint.domain.Account;
import com.banana.bananamint.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/bananamint/account")
@Validated
public class BananamintController {

    @Autowired
    private AccountService accountService;


    @PostMapping("/{cid}")
    public ResponseEntity<Account> createAccount(
            @RequestBody @Valid Account account,@PathVariable @Min(1) Long cid
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.open(cid,account));
    }
}
