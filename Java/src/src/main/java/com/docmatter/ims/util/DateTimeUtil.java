package com.docmatter.ims.util;

//import com.docmatter.Constant;
//import com.docmatter.util.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeUtil {
    private static String FORMAT_PATTERN = "yyyyMMdd";
    private static DateTimeFormatter _formatter = DateTimeFormatter.ofPattern(FORMAT_PATTERN);
    private static String THE_BEGINNING_OF_TIME = "19700101";


    /**
     * @param date  "Tue Feb 01 09:56:05 PST 2022"
     * @return
     */
    public static String UtilDateToLocateDateString(Date date) {
        if (date == null) return THE_BEGINNING_OF_TIME;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_PATTERN);
            TimeZone zone = TimeZone.getTimeZone("America/Los_Angeles");
            sdf.setTimeZone(zone);
            String result = sdf.format(date);
           return result;
        }catch (Exception e){
            e.printStackTrace();
            return THE_BEGINNING_OF_TIME;
        }
    }

    public static String getDefaultDateTimeString(){
        return THE_BEGINNING_OF_TIME;
    }


    public static Integer getDefaultDimDateId(){
        java.util.Date dt = new Date();
        String str = UtilDateToLocateDateString(dt);
        return Integer.valueOf(str);
    }

    /**
     * @param dateString like "2014/10/29 18:10:45";
     * @return
     * @throws ParseException
     */
    public static Long getMillsFromDateString(String dateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        TimeZone zone = TimeZone.getTimeZone("America/Los_Angeles");
        sdf.setTimeZone(zone);
        Date date = sdf.parse(dateString);
        long millis = date.getTime();
        return millis;
    }


    public static Integer getDimDateIdFromDateString(String dateString){
        return Integer.valueOf(dateString);
    }

    public static Integer getDimDateIdFromDateTicks(Long millis){
        Instant instance = java.time.Instant.ofEpochMilli(millis);
        ZonedDateTime zonedDateTime = java.time.ZonedDateTime
                .ofInstant(instance,java.time.ZoneId.of("America/Los_Angeles"));
        DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern(FORMAT_PATTERN);
        String formatedString = zonedDateTime.format(formatter);
        return Integer.valueOf(formatedString);
    }
}
