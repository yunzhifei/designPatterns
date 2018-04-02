package com.bj;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    public static String getYesterDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return sdf.format(calendar.getTime());
    }
}
