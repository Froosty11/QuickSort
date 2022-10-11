package com.company;

public class stackUnderFlow extends Exception {

    public stackUnderFlow(){
        super("You are facing a underflow");
    }

    stackUnderFlow(String message){
        super(message);
    }

}
