package com.lessons.vi_key.android1_les2;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import android.net.Uri;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by vi-key on 13.05.2016.
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;


        @Override
        protected void onCreate(Bundle savedInstanceState) {


            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
    //        getSupportActionBar().setTitle(R.string.);

            mPager = (ViewPager) findViewById(R.id.pager);
            mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
            mPager.setAdapter(mPagerAdapter);
            mPager.setOffscreenPageLimit(2);





        }

        public void showPopup(View v) {

            PopupMenu popup = new PopupMenu(this, v);
            popup.inflate(R.menu.popup);
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    showToast("нажали на popup");

                    return false;
                }
            });
            popup.show();
        }

    public void ShowDialogPicker(MenuItem item) {
        DialogFragment dialogDP = new DialogFragment();
        dialogDP.show(getFragmentManager(), "DATA_PICKER");
    }

    //    public void onClick(View v){
        //        Intent intent;
        //    }
        private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

            public ScreenSlidePagerAdapter(FragmentManager fm) {
                super(fm);
            }

            @Override
            public Fragment getItem(int position) {

                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new PageMain();
                        break;
                    case 1:
                        fragment = new PageSecond();
                        break;
                    default:
                }
                return fragment;
            }


            @Override
            public int getCount() {
                return 2;
            }
        }

    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
//        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();


        // if(mCurrentToast.getView().isShow())
//        if(mCurrentToast != null)
//        {
//            mCurrentToast.cancel();
//        }
//        mCurrentToast = Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT);
//        mCurrentToast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch(item.getItemId()) {
//            case R.id.delete:
//                showToast("Нажата delete");
//                break;
//            ///.. ниже так не стоит делать
//            case R.id.settings:
//                showToast("Нажата settings");
//                break;

            case R.id.main_menu_action_open_on_github:
                openUrl(getResources().getString(R.string.gitHubLnk));
                return true;
            case R.id.main_menu_action_open_on_linkedin:
                openUrl(getResources().getString(R.string.linkedInLnk));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openUrl(String url) {
        Intent intent= new Intent(Intent.ACTION_VIEW,Uri.parse(url));
        startActivity(intent);
    }


}