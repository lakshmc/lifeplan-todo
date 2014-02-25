package com.lifeplan.controllers.common;

import com.lifeplan.models.exception.DocumentNotFoundException;
import com.lifeplan.models.exception.ErrorResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.UUID;

/**
 * Created on 2/8/14.
 */
@ControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler {
    private final static Logger log = Logger.getLogger(GlobalExceptionController.class);
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleValidationException(Exception e) {
        return getErrorResponse(e);
    }

    @ExceptionHandler(value = {DocumentNotFoundException.class, DuplicateKeyException.class})
    @ResponseBody
    public ResponseEntity<Object> handleDocumentNotFoundException(Exception e, WebRequest request) {
        return handleExceptionInternal(e, getErrorResponse(e), new HttpHeaders(), HttpStatus.PRECONDITION_FAILED,
                request);
    }

    @ExceptionHandler(value = {BadCredentialsException.class})
    @ResponseBody
    public ResponseEntity<Object> handleBadCredentialsException(Exception e, WebRequest request) {
        return handleExceptionInternal(e, getErrorResponse(e), new HttpHeaders(), HttpStatus.BAD_REQUEST,
                request);
    }

    private ErrorResponse getErrorResponse(Exception ex) {
        final String errorReferenceId = getErrorReferenceId();
        final String errorMsg = new StringBuilder("Lifeplan-Error-ID:[")
                .append(errorReferenceId).append("]: ")
                .append(ex.getMessage()).toString();
        logger.error(errorMsg, ex);
        return new ErrorResponse(errorReferenceId, errorMsg);
    }

    private String getErrorReferenceId() {
        final String uuid = StringUtils.substring(UUID.randomUUID().toString().toUpperCase(), 0, 10);
        String hostName = null;
        try {
            hostName = StringUtils.substringBefore(Inet4Address.getLocalHost().getHostName(), ".");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return new StringBuilder(uuid).append("-")
                .append(StringUtils.substring(hostName, (hostName.length() - 3), hostName.length()))
                .toString();
    }
}
