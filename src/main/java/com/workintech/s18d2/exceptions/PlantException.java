package com.workintech.s18d2.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PlantException extends RuntimeException {

    private final HttpStatus httpStatus;

    public PlantException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}

