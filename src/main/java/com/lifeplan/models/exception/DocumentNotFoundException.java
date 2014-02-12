package com.lifeplan.models.exception;


import org.apache.log4j.Logger;

/**
 * Created on 2/10/14.
 */
public class DocumentNotFoundException extends RuntimeException {
    private static final Logger log = Logger.getLogger(DocumentNotFoundException.class);
    private static final long serialVersionUID = 1L;

    private String errCode;
    private String errMsg;
    private Object loggingMessage;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public DocumentNotFoundException(String errCode, String query, Class clazz, String errMsg) {
        this.errCode = errCode;
        loggingMessage = new StringBuilder("DocumentNotFoundException: query:{").append(query).append("} for Class:").append(clazz.getCanonicalName()).toString();
        this.errMsg = errMsg;
    }

    public Object getLoggingMessage() {
        return loggingMessage;
    }
}
