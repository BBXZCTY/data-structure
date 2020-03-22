package com.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Locale;

/**
 * @Author: hfr
 * @Date: 2019-07-25 17:13
 * @Version 1.0
 */
public class Test2 {

    public static void main(String[] args) {
        String lastDueDt = ADD_MONTH("2019-07-25", Integer.valueOf(30));
        System.out.println(lastDueDt);

        System.out.println(Math.max(2,8));
        System.out.println(Math.abs(-9));

    }

    public static String ADD_MONTH(String date, int n) {
        return ADD_DATE(2, date, n);
    }

    private static String ADD_DATE(int optype, String date, int num) {
        String st_return = "";

        try {
            DateFormat daf_date = DateFormat.getDateInstance(2, Locale.CHINA);
            daf_date.parse(date);
            Calendar calendar = daf_date.getCalendar();
            calendar.add(optype, num);
            String st_m = "";
            String st_d = "";
            int y = calendar.get(1);
            int m = calendar.get(2) + 1;
            int d = calendar.get(5);
            if (m <= 9) {
                st_m = "0" + m;
            } else {
                st_m = "" + m;
            }

            if (d <= 9) {
                st_d = "0" + d;
            } else {
                st_d = "" + d;
            }

            st_return = y + "-" + st_m + "-" + st_d;
        } catch (ParseException var11) {
            var11.printStackTrace();
        }

        return st_return;
    }

}