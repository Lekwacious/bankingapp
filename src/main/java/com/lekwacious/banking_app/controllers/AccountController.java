package com.lekwacious.banking_app.controllers;

import com.lekwacious.banking_app.data.models.Account;
import com.lekwacious.banking_app.data.payloads.reponse.ApiResponse;
import com.lekwacious.banking_app.data.payloads.request.AccountInfoRequest;
import com.lekwacious.banking_app.data.payloads.request.AccountRequest;
import com.lekwacious.banking_app.data.payloads.request.DepositRequest;
import com.lekwacious.banking_app.data.payloads.request.WithDrawalRequest;
import com.lekwacious.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public ApiResponse createAccount(@RequestBody AccountRequest accountRequest){
        accountService.createAccount(accountRequest);
        return new ApiResponse(true, "successful",HttpStatus.CREATED);
    }
    @PostMapping("/withdraw")
    public ApiResponse withdraw(@RequestBody WithDrawalRequest withDrawalRequest) throws Exception {
        accountService.withdraw(withDrawalRequest);
        return new ApiResponse(true, "successful",HttpStatus.OK);
    }
    @PostMapping("/deposit")
    public ApiResponse deposit(@RequestBody DepositRequest depositRequest){
        accountService.deposit(depositRequest);
        return new ApiResponse(true, "successful",HttpStatus.OK);

    }
    @PostMapping("/info")
    public ApiResponse getAccountInfo(@RequestBody AccountInfoRequest accountInfoRequest){
        accountService.getAccountInfo(accountInfoRequest);
        return new ApiResponse(true, "successful", HttpStatus.OK);

    }


}
