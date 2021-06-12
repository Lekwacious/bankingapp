package com.lekwacious.banking_app.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction {
    private LocalDate transactionDate = LocalDate.now();
    private TransactionType transactionType;
    private String narration;
    private Double amount;
    private Double accountBalance;

}
