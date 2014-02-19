package com.lifeplan.controllers.common;

import com.lifeplan.models.exception.DocumentNotFoundException;
import com.lifeplan.models.exception.ErrorResponse;
import org.apache.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created on 2/8/14.
 */
@ControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler {
    private final static Logger log = Logger.getLogger(GlobalExceptionController.class);
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody public String handleValidationException(Exception e){
        System.out.println(e);
        return e.getMessage();
    }

    @ExceptionHandler(DocumentNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody public ErrorResponse handleDocumentNotFoundException(DocumentNotFoundException e){
        log.error(e.getLoggingMessage());
        return new ErrorResponse("143",e.getMessage());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    @ResponseBody public ErrorResponse handleDuplicateKeyException(DuplicateKeyException e){
        log.error(e.toString());
        return new ErrorResponse("123",e.getMessage());
    }
}
