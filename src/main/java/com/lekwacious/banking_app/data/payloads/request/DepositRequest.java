package com.lekwacious.banking_app.data.payloads.request;

import lombok.Data;

@Data
public class DepositRequest {
    private String accountNumber;
    private Double amount;
}
