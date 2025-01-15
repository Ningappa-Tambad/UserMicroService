package com.springacademy.userservice.controlleradvise;


import com.springacademy.userservice.Exception.ValidTokenNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionhandler
{

    @ExceptionHandler(ValidTokenNotFoundException.class)
    public ResponseEntity<String> handleValidTokenNotFoundException()
    {
     ResponseEntity<String> response=new ResponseEntity<>("Token not found", HttpStatus.BAD_REQUEST);

     return response;
    }

}
