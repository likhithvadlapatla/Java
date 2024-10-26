package com.ge.exception;

public class TouristNotFoundException extends RuntimeException{

    /*This constructor overrides the message of Throwable class constructor.*/
    public TouristNotFoundException(String msg){
        super(msg);
    }
}
