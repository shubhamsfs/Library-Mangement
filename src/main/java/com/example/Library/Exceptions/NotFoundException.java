package com.example.Library.Exceptions;


public class NotFoundException extends RuntimeException {
    public NotFoundException(){
        super("no data found");
    }
}
