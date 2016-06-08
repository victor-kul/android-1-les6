package com.lessons.vi_key.android1_les2;

/**
 * Created by vi-key on 20.05.2016.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class PageMain extends Fragment {

    ImageView imageView, imageAva;
    Button button;
    ListView listView;



    private ArrayList<HashMap<String, Object>> mCatList;

    private static final String TITLE = "name";
    private static final String DESCRIPTION = "description";
    private static final String ICON = "icon";  // будущая картинка


    Toast mCurrentToast;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.page_main, null);


        listView = (ListView) view.findViewById(R.id.listView);

//        TextView text = (TextView) view.findViewById(R.id.text);
        button = (Button) view.findViewById(R.id.button);
        Button btn = (Button) view.findViewById(R.id.btn);

        imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.leather_wood2);

        imageAva = (ImageView) view.findViewById(R.id.imageAva);
        imageAva.setImageResource(R.drawable.ava_victor_kul);

        final Interpolator over = new OvershootInterpolator(4);

//        TListener tl = new TListener();
//        button.setOnTouchListener(tl);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showToast(R.string.txt_false);
                showToast("yea");
            }
        });


        mCatList = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> hm;


        String[] skills = this.getResources().getStringArray(R.array.my_skills);
        String[] titles = this.getResources().getStringArray(R.array.my_skills_title);

//        StringBuilder sBuilder = new StringBuilder();

        for (int i = 0; i < skills.length; i++) {
//            sBuilder.append(skills[i] + "\n");

            hm = new HashMap<String, Object>();
            hm.put(TITLE, titles[i]);
            hm.put(DESCRIPTION, skills[i]);
//        hm.put(ICON, R.mipmap.ic_launcher);
            mCatList.add(hm);

        }

//        hm.put(TITLE, "Рыжик");
//        hm.put(DESCRIPTION, "Рыжий и хитрый");
////        hm.put(ICON, R.mipmap.ic_launcher);
//        mCatList.add(hm);

//        text.setText(sBuilder.toString());
//        SimpleAdapter adapter = new SimpleAdapter(getActivity().getApplicationContext(), mCatList,
//                R.layout.list_item, new String[]{TITLE, DESCRIPTION, ICON},
//                new int[]{R.id.text1, R.id.text2, R.id.img});

        SimpleAdapter adapter = new SimpleAdapter(getActivity().getApplicationContext(), mCatList,
                R.layout.list_item, new String[]{TITLE, DESCRIPTION},
                new int[]{R.id.text1, R.id.text2});

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(itemClickListener);

        return view;
    }

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            HashMap<String, Object> itemHashMap = (HashMap <String, Object>) parent.getItemAtPosition(position);
            String titleItem = itemHashMap.get(TITLE).toString();
            String descriptionItem = itemHashMap.get(DESCRIPTION).toString();
//            int imageItem = (int)itemHashMap.get(ICON);
            Toast.makeText(getActivity().getApplicationContext(),
                    "- " + titleItem + ". " + descriptionItem, Toast.LENGTH_SHORT).show();
        }
    };


    private void showToast(String message) {
//        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
//        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();


        // if(mCurrentToast.getView().isShow())
        if(mCurrentToast != null)
        {
            mCurrentToast.cancel();
        }
        mCurrentToast = Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT);
        mCurrentToast.show();
    }


    class TListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                showToast("ACTION_DOWN");
                return true;
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                showToast("ACTION_UP");
                return true;
            }

            return false;
        }
    }

}
