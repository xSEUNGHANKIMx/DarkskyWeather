package com.seankim.darkskyweather.Utils;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class WeatherTime {
    private static Map<Integer, String> days = new HashMap<>();

    static {
        days.put(2, "MON");
        days.put(3, "TUES");
        days.put(4, "WED");
        days.put(5, "THU");
        days.put(6, "FRI");
        days.put(7, "SAT");
        days.put(1, "SUN");
    }

    public static String getDayOfWeek(Integer dateInt) {
        Long nowTimeLong = new Long(dateInt).longValue() * 1000;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

        try {
            Date now = format.parse(format.format(nowTimeLong));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(now);
            return days.get(calendar.get(Calendar.DAY_OF_WEEK));
        } catch (ParseException e) {

        }
        return days.get(Calendar.DAY_OF_WEEK);
    }

    public static String getDate(Integer dateInt) {
        Long nowTimeLong = new Long(dateInt).longValue() * 1000;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

        try {
            Date nowTimeDate = format.parse(format.format(nowTimeLong));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(nowTimeDate);
            return calendar.get(Calendar.MONTH) + 1 + File.separator + calendar.get(Calendar.DAY_OF_MONTH);
        } catch (ParseException e) {

        }
        return "";
    }

    public static String getTime(Integer dateInt) {
        Long nowTimeLong = new Long(dateInt).longValue() * 1000;
        DateFormat formatter = new SimpleDateFormat("HH:mm", Locale.US);

        try {
            Date nowTimeDate = formatter.parse(formatter.format(nowTimeLong));
            return formatter.format(nowTimeDate);
        } catch (ParseException e) {

        }
        return "";
    }
}
