package com.techwaala.crud_demo;


import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundException extends ResponseStatusException {
    public NotFoundException(HttpStatusCode status, String message) {
        super(status, message);
    }
}
