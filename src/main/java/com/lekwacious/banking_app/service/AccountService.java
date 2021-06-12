package com.lekwacious.banking_app.service;

import com.lekwacious.banking_app.data.models.Account;
import com.lekwacious.banking_app.data.payloads.reponse.ApiResponse;
import com.lekwacious.banking_app.data.payloads.request.AccountInfoRequest;
import com.lekwacious.banking_app.data.payloads.request.AccountRequest;
import com.lekwacious.banking_app.data.payloads.request.DepositRequest;
import com.lekwacious.banking_app.data.payloads.request.WithDrawalRequest;

public interface AccountService {
    ApiResponse createAccount(AccountRequest accountRequest);
    ApiResponse withdraw(WithDrawalRequest withDrawalRequest) throws Exception;
    ApiResponse deposit(DepositRequest depositRequest);
    ApiResponse getAccountInfo(AccountInfoRequest accountInfoRequest);
}
