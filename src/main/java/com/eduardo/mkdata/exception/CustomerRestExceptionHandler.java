package com.eduardo.mkdata.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

  @ExceptionHandler({ NumberFormatException.class })
  public ResponseEntity<Object> handleNumberFormatException() {
    return new ResponseEntity<>("Invalid Parameter", HttpStatus.BAD_REQUEST);
  }
}
