package com.lessons.vi_key.android1_les2;

/**
 * Created by vi-key on 20.05.2016.
 */

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PageSecond extends Fragment {


    private static final int CAMERA = 100;
    private static final int TEXT = 101;
    ImageView imagePhoto;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final EditText editText;
        final TextView editAll;
        ImageView imageView;
        final Button btn;

        View view = inflater.inflate(R.layout.second_page,null);


        imagePhoto = (ImageView) view.findViewById(R.id.imageVwScreen);


        imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.leather_wood2);


        editText = (EditText) view.findViewById(R.id.editTextEmail);
        editAll =  (TextView) view.findViewById(R.id.textAll);
        btn =      (Button) view.findViewById(R.id.btn);

        final Interpolator over = new OvershootInterpolator(4);

        btn.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(editText.getText().length() > 0)
                {
                    switch(event.getAction()){
                        // case MotionEvent.ACTION_DOWN; == 0
                        case 0:
                            Log.d("...", "Down сработал");
                            btn.animate().scaleX(0.75f).scaleY(0.75f).setDuration(750);
                            break;
                        case 1:
                            Log.d("...", "Up сработал");
                            btn.animate().scaleX(1f).scaleY(1f).setDuration(750).setInterpolator(over);
                            editAll.setText(editText.getText().toString() +"\n");
                            editAll.setVisibility(View.VISIBLE);
                            editAll.startAnimation(AnimationUtils.loadAnimation(getActivity().getApplicationContext(), android.R.anim.fade_in));
                            // editAll.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.fade_custom_anim));

                            break;
                    }
                }else{
                    Toast.makeText(getActivity().getApplicationContext(), "Заполните все поля", Toast.LENGTH_SHORT).show();
                    editAll.setVisibility(View.INVISIBLE);
                }

                return false;
            }
        });

        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == CAMERA && resultCode == RESULT_OK){
        if (requestCode == CAMERA){
            Bitmap cameraImg = (Bitmap) data.getExtras().get("data");
            imagePhoto.setImageBitmap(cameraImg);
        }
//        if (requestCode == TEXT){
//            Toast.makeText(this, data.getStringExtra("string"), Toast.LENGTH_SHORT).show();
//        }
//        if (requestCode == RESULT_CANCELED){
//            Toast.makeText(this, "Wrong Data", Toast.LENGTH_SHORT).show();
//        }
    }
}
