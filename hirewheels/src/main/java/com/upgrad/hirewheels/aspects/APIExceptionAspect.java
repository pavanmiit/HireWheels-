package com.upgrad.hirewheels.aspects;

import com.upgrad.hirewheels.response.CustomResponse;
import exceptions.APIException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionAspect {

    @ExceptionHandler(APIException.class)
    public ResponseEntity<CustomResponse> handleAPIException(Exception e){
        CustomResponse response = new CustomResponse(e.getMessage(),e.hashCode(),HttpStatus.EXPECTATION_FAILED.value());
        return  new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }
}
