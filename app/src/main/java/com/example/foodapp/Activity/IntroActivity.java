package com.example.foodapp.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.foodapp.R;

public class IntroActivity extends  AppCompatActivity {

    ImageView image_background,intro_image;

    TextView name_app,text_deliveryapp;
    AppCompatButton getstarted_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        image_background=findViewById(R.id.image_background);
        intro_image=findViewById(R.id.intro_image);
        name_app=findViewById(R.id.name_app);
        text_deliveryapp=findViewById(R.id.text_deliveryapp);
        getstarted_button=findViewById(R.id.getstarted_button);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //status bar color
        //to put color from resource: getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        //to put color directrly:getWindow().setStatusBarColor(Color.parseColor("#FFE485")); Color.parse() howe l color integer fa color.parse bt7awel Strin la integer 7a t2ol lesh ma sta3mlna Integer.parse() bas hayde 7a tale3 expecption eno momken l string l 7a ta3teh ma ykoun la loun ykoun 3ade text
        getWindow().setStatusBarColor(getResources().getColor(R.color.orange));
        //for navigation getWindow().setNavigationBarColor(getResources().getColor(R.color.white));

        setVariable();
    }

    private void setVariable() {
        getstarted_button.setOnClickListener(v->{
            Intent intent=new Intent(getApplicationContext(), BaseActivity.class);
            startActivity(intent);
            finish();
        });
    }
}