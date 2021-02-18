package com.upgrad.hirewheels.aspects;

import com.upgrad.hirewheels.response.CustomResponse;
import exceptions.APIException;
import exceptions.UserAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserAlreadyExistsExceptionAspect {
    @ExceptionHandler(UserAlreadyExists.class)
    public ResponseEntity<CustomResponse> handleUserAlreadyExistsException(Exception e){
        CustomResponse response = new CustomResponse(e.getMessage(),e.hashCode(), HttpStatus.EXPECTATION_FAILED.value());
        return  new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }
}
