package com.lekwacious.banking_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourcesNotFoundException extends RuntimeException{
    public ResourcesNotFoundException(String message){
        super(message);
    }
    public ResourcesNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
