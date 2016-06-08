package com.lessons.vi_key.android1_les2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by vi-key on 13.05.2016.
 */
public class OtherActivity extends AppCompatActivity {



    private static final int CAMERA = 100;
    private static final int TEXT = 101;

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

    public void onClickScreenBtn(View view) {
        Intent intent;

        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http//"));
                startActivity(intent);
//        startActivityForResult(intent, CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, CAMERA);
        }
    }
}

//    public void btnClick(View view) {    }

