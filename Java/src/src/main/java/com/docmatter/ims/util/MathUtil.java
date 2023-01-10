package com.docmatter.ims.util;

import com.docmatter.ims.exception.ImsException;
import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MathUtil {

    private static final Long ENTITY_MULTIPLIER = 1000_000L;
    private static final int MEASURED_OPERATION_MULTIPLIER = 10_000;

    public static long encodeForEntity(int val_ctxType, int val_ctxId) {
        return val_ctxType + val_ctxId * ENTITY_MULTIPLIER;
    }

    public static int[] decodeForEntity(Long val) {
        return new int[]{
                (int)(val % ENTITY_MULTIPLIER),
                (int)(val / ENTITY_MULTIPLIER)
        };
    }

    public static long encodeForOperation(int actionTarget, int action) {
        return actionTarget + action * MEASURED_OPERATION_MULTIPLIER;
    }

    public static int[] decodeForOperation(Long val) {
        return new int[]{
                (int)(val % MEASURED_OPERATION_MULTIPLIER),
                (int)(val / MEASURED_OPERATION_MULTIPLIER)
        };
    }

    public static Date convertToDate(String intStr) throws ImsException, ParseException {
        if(intStr.length() != 8){
            throw new ImsException("Error: invalid parameter for getValueFromIntegerString, with value for param intstr as " + intStr);
        }
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
        return originalFormat.parse(intStr);
    }

    public static Date getLocalDateFromIntegerString(String intStr) throws ImsException, ParseException {
        if(!StringUtils.isNotEmpty(intStr)){
            throw new ImsException("Error: invalid parameter for getValueFromIntegerString, value for param intStr is null or emtpy!");
        }
        if(intStr.indexOf(".") > 0){
            intStr = intStr.substring(0, intStr.indexOf(".")) ;
        }
        return convertToDate(intStr);
    }
}
