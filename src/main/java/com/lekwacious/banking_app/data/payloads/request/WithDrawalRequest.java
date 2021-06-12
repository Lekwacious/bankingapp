package com.lekwacious.banking_app.data.payloads.request;

import lombok.Data;

@Data
public class WithDrawalRequest {
    private String accountNumber;
    private String accountPassword;
    private Double withdrawalAmount;
}
