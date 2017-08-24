package cashkaro.com.dashboad;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.androidbuts.multispinnerfilter.KeyPairBoolData;
import com.androidbuts.multispinnerfilter.MultiSpinner;
import com.androidbuts.multispinnerfilter.MultiSpinnerListener;

import java.util.ArrayList;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.filtercustomactionbar);//
        View view = getSupportActionBar().getCustomView();
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

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.animator.left_to_right, R.animator.right_to_left);
        super.onBackPressed();
    }
}
