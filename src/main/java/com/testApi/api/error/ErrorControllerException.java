package com.testApi.api.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ErrorControllerException extends RuntimeException {

    public ErrorControllerException(String message){
        super(message);
    }
}
