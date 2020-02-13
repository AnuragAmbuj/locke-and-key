package com.freecharge.mob.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class QueueEmptyException extends Exception {

    private String message = "Queue is empty";

    @Override
    public String getMessage(){
        return message;
    }
}