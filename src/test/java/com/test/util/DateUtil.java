package com.test.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author: hfr
 * @Date: 2019-07-31 18:07
 * @Version 1.0
 */
public class DateUtil {

    public static int daysBetween(Date newerDate, Date olderDate) {
        Calendar cNow = Calendar.getInstance();
        Calendar cReturnDate = Calendar.getInstance();
        cNow.setTime(newerDate);
        cReturnDate.setTime(olderDate);
        setTimeToMidnight(cNow);
        setTimeToMidnight(cReturnDate);
        long todayMs = cNow.getTimeInMillis();
        long returnMs = cReturnDate.getTimeInMillis();
        long intervalMs = todayMs - returnMs;
        return millisecondsToDays(intervalMs);
    }

    private static int millisecondsToDays(long intervalMs) {
        return (int) (intervalMs / (1000 * 86400));
    }

    private static void setTimeToMidnight(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
    }

    public static Date stringToDate(String str, String dateFormat) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            // Fri Feb 24 00:00:00 CST 2012
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date addDays(Date date, int diffDays) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + diffDays);
            return calendar.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getAddMonth(int month){
        Calendar curr = Calendar.getInstance();
        curr.set(Calendar.MONTH,curr.get(Calendar.MONTH)+month); //增加一月
        Date date=curr.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(date);
        return dateNowStr;
    }

    public static Date addMonth(Date mon, int mons) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mon);
        calendar.add(Calendar.MONTH, mons); //加一个月
        return calendar.getTime();
    }


    public static void main(String[] args) {
        Date now = stringToDate("2019-07-31","yyyy-MM-dd");
        Date dt = stringToDate("2019-07-29","yyyy-MM-dd");
        int allowRepayDay = 1;
        System.out.println(daysBetween(now,dt));
        String repayDay = new SimpleDateFormat("yyyy-MM-dd").format(addDays(dt, allowRepayDay));
        System.out.println(repayDay);

        long time = 2L;
        int a = new Long(time).intValue();
        System.out.println(time);
        System.out.println(a);

        String str = null;
//        System.out.println(new BigDecimal(str));

        List<String> list = new ArrayList<String>();
//        System.out.println(list.get(0));

        System.out.println(DateUtil.getAddMonth(5));
        System.out.println(addMonth(stringToDate("2019-07-31","yyyy-MM-dd"), 4));


    }
}