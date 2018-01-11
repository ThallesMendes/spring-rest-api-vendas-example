package com.smn.apivendas.contracts;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class ApiError {

    private HttpStatus status;
    private String message;
    private String exception;
    private List<String> errors;

    public ApiError( HttpStatus status ,String message, String exception, List<String> errors ){
        super();

        this.status = status;
        this.message = message;
        this.exception = exception;
        this.errors = errors;

    }

    public ApiError(HttpStatus status ,String message, String exception, String error){
        super();

        this.status = status;
        this.message = message;
        this.exception = exception;
        this.errors = Arrays.asList(error);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
