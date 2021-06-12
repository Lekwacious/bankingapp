package com.lekwacious.banking_app.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private String accountName;
    private String accountNumber;
    private Double accountBalance;
    private String accountPassword;


    public double deposit(Double amount) {
        return accountBalance += amount;
    }
   public double withdraw (double amount) {
        return accountBalance -= amount;
    }
}
