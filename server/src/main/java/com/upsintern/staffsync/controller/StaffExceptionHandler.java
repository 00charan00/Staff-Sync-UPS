package com.upsintern.staffsync.controller;

import com.upsintern.staffsync.ResponseBase;
import com.upsintern.staffsync.exception.StaffNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StaffExceptionHandler {

    @ExceptionHandler(StaffNotFoundException.class)
    public ResponseEntity<ResponseBase> handleNotFound(StaffNotFoundException exception){
        ResponseBase responseBase = new ResponseBase(exception.getMessage(),false);
        return new ResponseEntity<>(responseBase, HttpStatus.NOT_FOUND);
    }
}
