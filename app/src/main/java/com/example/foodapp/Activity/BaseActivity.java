package com.example.foodapp.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.foodapp.R;

public class BaseActivity extends AppCompatActivity {

    ImageView image_background,intro_image;
    TextView text_deliveryapp,login_intro,signup_intro;
    View view_intro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        image_background=findViewById(R.id.image_background);
        intro_image=findViewById(R.id.intro_image);
        text_deliveryapp=findViewById(R.id.text_deliveryapp);
        login_intro=findViewById(R.id.login_intro);
        signup_intro=findViewById(R.id.signup_intro);
        view_intro=findViewById(R.id.view_intro);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setStatusBarColor(getResources().getColor(R.color.orange));

        button_intro();


    }

    private void button_intro() {
        login_intro.setOnClickListener(v->{
            Intent intent=new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();

        });

        signup_intro.setOnClickListener(v->{
            Intent intent=new Intent(getApplicationContext(),SignupActivity.class);
            startActivity(intent);
            finish();
        });
    }
}