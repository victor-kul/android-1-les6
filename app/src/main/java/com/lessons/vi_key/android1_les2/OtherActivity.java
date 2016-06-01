package com.lessons.vi_key.android1_les2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;

/**
 * Created by vi-key on 13.05.2016.
 */
public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
//        Log.d("...", "Сработал onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("...", "Сработал onDestroy");
    }

//    public void btnClick(View view) {    }
}
