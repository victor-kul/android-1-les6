package com.lessons.vi_key.android1_les2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by admin on 26.05.2016.
 */
public class DataPickFragment extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    protected Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // return super.onCreate...
//        return new DatePickerDialog(getActivity(), this, year,month,day);
        return new DatePickerDialog(this, this, year,month,day);

    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

    }
}
