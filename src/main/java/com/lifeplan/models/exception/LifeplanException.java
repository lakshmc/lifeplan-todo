package com.lifeplan.models.exception;

/**
 * Created on 2/27/14.
 */
public class LifeplanException extends RuntimeException {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
