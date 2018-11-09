package com.seankim.darkskyweather.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class WeatherTime {
    private static Map<Integer, String> weekDayMap = new HashMap<>();

    static {
        weekDayMap.put(2, "MONDAY");
        weekDayMap.put(3, "TUESDAY");
        weekDayMap.put(4, "WEDNESDAY");
        weekDayMap.put(5, "THURSDAY");
        weekDayMap.put(6, "FRIDAY");
        weekDayMap.put(7, "SATURDAY");
        weekDayMap.put(1, "SUNDAY");
    }

    public static String getDayOfWeek(Integer dateInt) {
        long nowTimeLong = new Long(dateInt).longValue() * 1000;
        DateFormat ymdhmsFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.TAIWAN);
        String nowTimeStr = ymdhmsFormat.format(nowTimeLong);
        try {
            Date nowTimeDate = ymdhmsFormat.parse(nowTimeStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(nowTimeDate);
//            Log.e("KYTime", calendar.get(Calendar.DAY_OF_WEEK) +"");
            return weekDayMap.get(calendar.get(Calendar.DAY_OF_WEEK));
        } catch (ParseException e) {

        }
        return weekDayMap.get(Calendar.DAY_OF_WEEK);
    }

    public static String getDate(Integer dateInt) {
        long nowTimeLong = new Long(dateInt).longValue() * 1000;
        DateFormat ymdhmsFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.TAIWAN);
        String nowTimeStr = ymdhmsFormat.format(nowTimeLong);
        try {
            Date nowTimeDate = ymdhmsFormat.parse(nowTimeStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(nowTimeDate);
            return calendar.get(Calendar.MONTH) + 1 + "/" + calendar.get(Calendar.DAY_OF_MONTH);
        } catch (ParseException e) {

        }
        return "10/10";

    }
}
