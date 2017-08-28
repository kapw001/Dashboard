package cashkaro.com.dashboad;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static cashkaro.com.dashboad.R.id.textView;

/**
 * Created by yasar on 26/8/17.
 */

public class Utils {
    private static SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

    public static String getMonthByName(String date) {
        Date dt1 = null;
        try {
            dt1 = format1.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat format2 = new SimpleDateFormat("MMM");
        String finalDay = format2.format(dt1);
        return finalDay;
    }

    public static String getDaysByNumber(String date) {
        Date dt1 = null;
        try {
            dt1 = format1.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat format2 = new SimpleDateFormat("dd");
        String finalDay = format2.format(dt1);
        return finalDay;
    }

    public static String getDaysByName(String date) {

        Date dt1 = null;
        try {
            dt1 = format1.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat format2 = new SimpleDateFormat("EEE");
        String finalDay = format2.format(dt1);
        return finalDay;
    }

    public static Date convertStringToDate(String s) {
        String str_date = s;
        Date date = null;
        try {
            date = format1.parse(str_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }




    public static String convertDateToString(Date date) {
        String s = format1.format(date);
        return s;
    }

    public static long getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public static long putdays(String startdate, String enddate) throws ParseException {
        String str_date = startdate;
        String end_date = enddate;
        Date s;
        Date e;
        s = format1.parse(str_date);
        e = format1.parse(end_date);
        long diff = e.getTime() - s.getTime();
        long leavedays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1;
        return leavedays;
    }

    public static String addDays(String d) {
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format1.parse(d));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.DATE, 31);  // number of days to add, can also use Calendar.DAY_OF_MONTH in place of Calendar.DATE

        return format1.format(c.getTime());
    }

}
