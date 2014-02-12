package com.lifeplan.logic.util;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created on 2/10/14.
 */
public class DateUtil {
    private DateUtil(){}

    public static String getDateTimeInString(DateTime dt){
        return dt.toString();
    }
    public static String getCurrentDateTimeInString(){
        return DateTime.now().toString();
    }
}
