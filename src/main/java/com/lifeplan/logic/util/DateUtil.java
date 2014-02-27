package com.lifeplan.logic.util;

import org.joda.time.DateTime;

/**
 * Created on 2/10/14.
 */
public class DateUtil {
    private DateUtil() {
    }

    public static String getDateTimeInString(DateTime dt) {
        return dt.toString();
    }

    public static String getCurrentDateTimeInString() {
        return DateTime.now().toString();
    }

    public static DateTime getCurrentDateTime() {
        return new DateTime();
    }
}
