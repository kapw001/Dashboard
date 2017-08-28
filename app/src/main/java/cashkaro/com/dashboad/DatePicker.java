package cashkaro.com.dashboad;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.WindowManager;

import java.util.Calendar;

/**
 * Created by yasar on 26/8/17.
 */

public class DatePicker {

    public static void showDatePicker(Context context, final CallBackDayPickerValues callBackDayPickerValues) {
        int mYear, mMonth, mDay, mHour, mMinute;
        // Get Current Date
        final Calendar c = Calendar.getInstance();

        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(android.widget.DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
//                        year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;

                        callBackDayPickerValues.showDateValues(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    }
                }, mYear, mMonth, mDay);


        datePickerDialog.show();

    }


    interface CallBackDayPickerValues {

        void showDateValues(String datepicker);
    }
}
