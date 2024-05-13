package com.akp.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.akp.android.Basic.SplashScreen;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout dash_ll,logout_ll;
    private ImageView sliding_menu;
    private DrawerLayout mDrawer;
    private ImageView close;
    SliderLayout slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findId();

        sliding_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
//                mDrawer.openDrawer(Gravity.START);
                mDrawer.openDrawer(Gravity.START);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDrawer.closeDrawer(Gravity.START);
                    }
                });
                dash_ll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDrawer.closeDrawer(Gravity.START);
                    }
                });
                logout_ll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDrawer.closeDrawer(Gravity.START);
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Are you sure want to logout?");
                        builder.setPositiveButton(Html.fromHtml("<font color='#E5B80B'>Yes</font>"), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences myPrefs = getSharedPreferences("login_preference", MODE_PRIVATE);
                                SharedPreferences.Editor editor = myPrefs.edit();
                                editor.clear();
                                editor.commit();
                                Intent intent = new Intent(getApplicationContext(), SplashScreen.class);
                                intent.putExtra("finish", true);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // To clean up all activities
                                startActivity(intent);
                            }
                        });
                        builder.setNegativeButton(Html.fromHtml("<font color='#E5B80B'>NO</font>"), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.show(); }}); }});

    }

    private void findId() {
        dash_ll=findViewById(R.id.dash_ll);
        logout_ll=findViewById(R.id.logout_ll);
        close=findViewById(R.id.close);
        sliding_menu = (ImageView) findViewById(R.id.sliding_menu);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        slider = (SliderLayout) findViewById(R.id.slider);
        setSliderViews();
    }

    private void setSliderViews() {
        for (int i = 0; i <= 4; i++) {
            SliderView sliderView = new SliderView(MainActivity.this);
            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.b1);
                    sliderView.setDescription("Welcome To\n" +
                            "MaharajaPro Group");
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.b2);
//                    sliderView.setDescription("सच होगा सपना");
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.b3);;
//                    sliderView.setDescription("सोचो  एक  नयी  दुनिया ");
                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.b4);;
//                    sliderView.setDescription("खुशियां  हो  जहाँ  ");
                    break;
                case 4:
                    sliderView.setImageDrawable(R.drawable.b5);;
//                    sliderView.setDescription("खुशियां  हो  जहाँ  ");
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(getApplicationContext(), "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });
            //at last add this view in your layout :
            slider.addSliderView(sliderView);
        }
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton(Html.fromHtml("<font color='#000000'>Yes</font>"), new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id) {
                        //finish();
                        onSuperBackPressed();
                        //super.onBackPressed();
                    }
                })
                .setNegativeButton(Html.fromHtml("<font color='#000000'>No</font>"), new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    /*
    if (handleCancel()){
        super.onBackPressed();
    }
    */
    }

    public void onSuperBackPressed(){
        super.onBackPressed();
    }

}


