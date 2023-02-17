package com.testApi.api.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PersistenceException extends RuntimeException {
    public PersistenceException(String message){
        super(message);
    }
}
