package com.nice.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by deepesh nellutla on 2/24/2017.
 * Exception class to display custom display message to the user
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    String displayMessage;
    public NotFoundException(String displayMessage){
        super(displayMessage);
        this.displayMessage = displayMessage;
    }
}
