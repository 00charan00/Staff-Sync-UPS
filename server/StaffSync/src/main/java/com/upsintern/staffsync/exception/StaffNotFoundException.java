package com.upsintern.staffsync.exception;

public class StaffNotFoundException extends RuntimeException{
    public StaffNotFoundException(String msg){
        super(msg);
    }
}
