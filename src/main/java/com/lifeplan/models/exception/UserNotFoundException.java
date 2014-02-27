package com.lifeplan.models.exception;

/**
 * Created on 2/27/14.
 */
public class UserNotFoundException extends LifeplanException {

    public UserNotFoundException(String msg) {
        super.setMessage("The requested User does not exist. " + msg);
    }
}
