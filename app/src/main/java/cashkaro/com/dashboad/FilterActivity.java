package cashkaro.com.dashboad;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androidbuts.multispinnerfilter.KeyPairBoolData;
import com.androidbuts.multispinnerfilter.MultiSpinner;
import com.androidbuts.multispinnerfilter.MultiSpinnerListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import cashkaro.com.dashboad.adapter.MultiSelectionSpinner;
import io.apptik.widget.multiselectspinner.BaseMultiSelectSpinner;
import io.apptik.widget.multiselectspinner.MultiSelectSpinner;

public class FilterActivity extends AppCompatActivity {


    private List<String> list;

    private MultiSelectionSpinner spinner;

    private ImageView back;
    private RelativeLayout reset, accept;
    private TextView startdate, enddate;

    private RadioGroup radioGroup;

    private RadioButton radioButton;

    private String startdateTxt, enddateTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Check if the version of Android is Lollipop or higher
        if (Build.VERSION.SDK_INT >= 21) {

            // Set the status bar to dark-semi-transparentish
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


        }

        setContentView(R.layout.activity_filter);

        radioGroup = (RadioGroup) findViewById(R.id.rdogrp);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

//                radioButton = (RadioButton) findViewById(i);

                setDate(startdateTxt);

            }
        });

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.filtercustomactionbar);//
        View view = getSupportActionBar().getCustomView();

        startdate = (TextView) findViewById(R.id.startdate);
        enddate = (TextView) findViewById(R.id.enddate);

        setDate(Utils.convertDateToString(new Date()));

        startdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePicker.showDatePicker(FilterActivity.this, new DatePicker.CallBackDayPickerValues() {
                    @Override
                    public void showDateValues(String datepicker) {

                        int selectedId = radioGroup.getCheckedRadioButtonId();
                        startdateTxt = datepicker;
                        if (selectedId == R.id.month) {
                            String d = Utils.convertDateToString(Utils.convertStringToDate(datepicker));

                            String v = Utils.getMonthByName(d) + "," + Utils.getDaysByNumber(d);

                            startdate.setText(v);

                            String v1 = Utils.getMonthByName(Utils.addDays(d)) + "," + Utils.getDaysByNumber(Utils.addDays(d));

                            enddate.setText(v1);
                        } else {
                            String d = Utils.convertDateToString(Utils.convertStringToDate(datepicker));

//                            String v = Utils.getMonthByName(d) + "," + Utils.getDaysByNumber(d);

                            startdate.setText(d);

                            String v1 = Utils.addDays(d);

                            enddate.setText(v1);
                        }

                    }
                });
            }
        });

        enddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePicker.showDatePicker(FilterActivity.this, new DatePicker.CallBackDayPickerValues() {
                    @Override
                    public void showDateValues(String datepicker) {

                        int selectedId = radioGroup.getCheckedRadioButtonId();

                        if (selectedId == R.id.month) {
                            String d = Utils.convertDateToString(Utils.convertStringToDate(datepicker));
                            String v = Utils.getMonthByName(d) + "," + Utils.getDaysByNumber(d);
                            enddate.setText(v);
                        } else {
                            String d = Utils.convertDateToString(Utils.convertStringToDate(datepicker));
                            enddate.setText(d);
                        }
                    }
                });
            }
        });

        back = (ImageView) view.findViewById(R.id.back);
        reset = (RelativeLayout) view.findViewById(R.id.reset);
        accept = (RelativeLayout) view.findViewById(R.id.accept);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
                overridePendingTransition(R.animator.left_to_right, R.animator.right_to_left);
//                FilterActivity.super.onBackPressed();
//                Toast.makeText(FilterActivity.this, "Back", Toast.LENGTH_SHORT).show();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FilterActivity.this, "Reset", Toast.LENGTH_SHORT).show();
            }
        });

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FilterActivity.this, "Accept", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();

                intent.putStringArrayListExtra("school_list", spinner.getSelectedList());
                intent.putExtra("monthorday", radioGroup.getCheckedRadioButtonId());
                intent.putExtra("startdate", startdate.getText().toString());
                intent.putExtra("enddate", enddate.getText().toString());

                setResult(2,intent);
                finish();


            }
        });


        list = new ArrayList<>();
        list.add("School I");
        list.add("School II");
        list.add("School III");
        list.add("School IV");
        list.add("School V");


        // Multi spinner
        spinner = (MultiSelectionSpinner) findViewById(R.id.mySpinner1);
        spinner.setItems(list);


    }

    private void setDate(String dateValues) {
        startdateTxt = dateValues;
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId == R.id.month) {
            String d = Utils.convertDateToString(Utils.convertStringToDate(dateValues));

            String v = Utils.getMonthByName(d) + "," + Utils.getDaysByNumber(d);

            startdate.setText(v);

            String v1 = Utils.getMonthByName(Utils.addDays(d)) + "," + Utils.getDaysByNumber(Utils.addDays(d));

            enddate.setText(v1);
        } else {


            String d = Utils.convertDateToString(Utils.convertStringToDate(dateValues));

//                            String v = Utils.getMonthByName(d) + "," + Utils.getDaysByNumber(d);

            startdate.setText(d);

            String v1 = Utils.addDays(d);

            enddate.setText(v1);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.animator.left_to_right, R.animator.right_to_left);
        super.onBackPressed();
    }
}
