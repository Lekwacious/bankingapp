package com.lekwacious.banking_app.service;

import com.lekwacious.banking_app.data.models.Transaction;
import com.lekwacious.banking_app.data.payloads.request.AccountInfoRequest;

import java.util.List;

public interface TransactionService {
    List<Transaction> findByAccountNumberEquals(AccountInfoRequest accountInfoRequest);
}
