package com.coccoc.coccoctestapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Luong Vo on 1/20/17.
 */

public class StringUtils {

    private StringUtils() {
        throw new AssertionError();
    }

    public static String formatDate_ddMMyyyy(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return formatDateTimeString(date, dateFormat);
    }

    private static String formatDateTimeString(Date date, SimpleDateFormat dateFormat) {
        if (date == null) {
            return "";
        } else if (date.getTime() == 0) {
            return "N/A";
        }
        return dateFormat.format(date);
    }

}
