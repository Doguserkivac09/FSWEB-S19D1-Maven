package com.workintech.s18d2.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class PlantException extends RuntimeException{
private HttpStatus httpStatus;
public PlantException(String message ){
    super(message);

}

}
