package com.banana.bananamint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bananamint")
public class BananamintController {

    @Autowired
    private AccountService accountService;



    @PostMapping("")
    public ResponseEntity<Account> createAccount(
            @RequestBody Account account
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.create(account));
    }

}

