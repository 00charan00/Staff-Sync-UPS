package com.upsintern.staffsync.controller;

import com.upsintern.staffsync.responsemodel.ResponseBase;
import com.upsintern.staffsync.exception.InvalidDataException;
import com.upsintern.staffsync.exception.StaffNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin
public class StaffExceptionHandler {

    @ExceptionHandler(StaffNotFoundException.class)
    public ResponseEntity<ResponseBase> handleNotFound(StaffNotFoundException exception){
        ResponseBase responseBase = new ResponseBase(exception.getMessage(),false);
        return new ResponseEntity<>(responseBase, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ResponseBase> handleInvalid(InvalidDataException exception){
        ResponseBase responseBase = new ResponseBase(exception.getMessage(),false);
        return new ResponseEntity<>(responseBase, HttpStatus.BAD_REQUEST);
    }
}
