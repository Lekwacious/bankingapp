package com.lekwacious.banking_app.data.payloads.reponse;

import com.lekwacious.banking_app.data.models.Account;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponse {
    private Boolean success;
    private String message;
    private HttpStatus responseCode;
//    private Account account;

    public ApiResponse(Boolean success, String message, HttpStatus responseCode){
        this.success = success;
        this.message = message;
        this.responseCode = responseCode;
    }

}
