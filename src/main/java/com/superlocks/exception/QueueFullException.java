package com.superlocks.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class QueueFullException extends Exception {

    private String message = "Queue is full";

    @Override
    public String getMessage(){
        return message;
    }
}
