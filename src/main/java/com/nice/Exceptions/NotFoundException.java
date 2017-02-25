package com.nice.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Cigniti_1868 on 2/24/2017.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    String displayMessage;
    public NotFoundException(String displayMessage){
        super(displayMessage);
        this.displayMessage = displayMessage;
    }
}
