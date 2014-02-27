package com.lifeplan.models.exception;

/**
 * Created on 2/27/14.
 */
public class UsernameAlreadyExistsException extends LifeplanException {

    public UsernameAlreadyExistsException(String msg) {
        super.setMessage("The provided username already exists. " + msg);
    }
}
