package com.lekwacious.banking_app.data.payloads.request;

import lombok.Data;

@Data
public class AccountInfoRequest {
    private String accountNumber;
    private String accountPassword;
}
