package com.lekwacious.banking_app.service;

import com.lekwacious.banking_app.data.models.Account;
import com.lekwacious.banking_app.data.models.Transaction;
import com.lekwacious.banking_app.data.payloads.request.AccountInfoRequest;

import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private List<Transaction> listOfTransaction = new ArrayList<>();

    @Override
    public List<Transaction> findByAccountNumberEquals(AccountInfoRequest accountInfoRequest) {
//        Account account = new Transaction();

        return null;
    }
}
