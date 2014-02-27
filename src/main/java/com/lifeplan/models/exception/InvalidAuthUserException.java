package com.lifeplan.models.exception;

/**
 * Created on 2/27/14.
 */
public class InvalidAuthUserException extends LifeplanException {


    public InvalidAuthUserException(String msg, String... args) {
        super.setMessage(getErrorMsg(msg, args));
    }

    private String getErrorMsg(String msg, String... args) {
        StringBuffer sb = new StringBuffer(msg);
        if (args.length > 0) {
            sb.append(" [");
            for (String s : args) {
                sb.append(s).append(",");
            }
            sb.setCharAt(sb.length() - 1, ']');
        }
        return sb.toString();
    }
}
