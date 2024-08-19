package com.example.foodapp.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodapp.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setStatusBarColor(getResources().getColor(R.color.orange));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.orange));

        //hawde 7a yeshte8lo independent ya3ne ka2no 7atet 2 time 7ed ba3d w sha8lton mesh eno tene handler la7 tentor 2awl handler la t5ales ba3den tblesh la2 bas howe l a7san na3meloun nested handler eno
        //2awl handler tblesh ba3d seney w nous t8ayer l status w navigation ba3den b2laba tenshe2 new handler feha intent tblesh ba3d senye false 7
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                getWindow().setStatusBarColor(getResources().getColor(R.color.white));
//                getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
//
//            }
//        },1500);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent=new Intent(getApplicationContext(),IntroActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        },3200);



//le sar 2awl she ba3d seneye w nous mn run l app la7 yet8ayar l loun l status w naviagtion ba3d ma t5les ta8yer la yensha2 newhandler w la7 ta3mel post ba3d seneye fasle 8 ya3ne bheek btkoun l 3amlye 2a5det 3.8
        //ama hounek bhedek tare2a 7a te5od l 3amlye l 2ola 1.5 w l 3amlye tenye 3.7 w independeny ya3ne k2no 7atet se3ten 7ed ba3d w mashe l wa2t se3ten ma3 ba3d 2awl se3a 7a t5ales b seneye w nous tene se3a bt5eles wa2t yseer l wa2t 3.7
        //amam bhay tare2a ka2nak 7atet se3a wa7de w badak ta3mel sha8letn ba3d ma te5las 2awl sha8le btblesh teneye ya3ne 3ayart seneye w nous 3al se3a ba3d ma 5elso seneye w nous rje3t safrt se3a w 3ayrt seney false 8

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getWindow().setStatusBarColor(getResources().getColor(R.color.white));
                getWindow().setNavigationBarColor(getResources().getColor(R.color.white));

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(getApplicationContext(),IntroActivity.class);
                       startActivity(intent);
                       finish();
                    }
                },1800);
            }
        },1500);

    }
}