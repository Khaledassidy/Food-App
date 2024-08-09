package com.example.foodapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;


import com.example.foodapp.Database.Database;
import com.example.foodapp.Database.DatabaseAcces;
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.Helper.Cart;
import com.example.foodapp.Helper.bestfood;
import com.example.foodapp.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    ImageView image_item;
    ImageView favorite_btn;
    ImageView image_clock;
    TextView title_item;
    TextView price_item;
    TextView text_rating;
    TextView time_details;
    TextView text_detals;
    TextView details_item;
    TextView quntity_text;
    TextView minus_btn;
    TextView number_item;
    TextView plus_item;
    TextView total_price_txt;
    TextView price_item_detals;
    Button add_to_card_btn;
    RatingBar ratingBar;
    Toolbar toolbar;
    CoordinatorLayout coordinatorLayout;
    NestedScrollView nestedScrollView;
    ConstraintLayout quntitiy;
    int num=0;
    int foodId;
    Foods object;
    String name;
    String originalToolbarTitle=null;
    boolean flag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        image_item=findViewById(R.id.image_item);
        image_clock=findViewById(R.id.image_clock);
        title_item=findViewById(R.id.title_item);
        price_item=findViewById(R.id.price_item);
        text_rating=findViewById(R.id.text_rating);
        time_details=findViewById(R.id.time_details);
        text_detals=findViewById(R.id.text_detals);
        details_item=findViewById(R.id.details_item);
        minus_btn=findViewById(R.id.minus_btn);
        number_item=findViewById(R.id.number_item);
        plus_item=findViewById(R.id.plus_item);
        total_price_txt=findViewById(R.id.total_price_txt);
        price_item_detals=findViewById(R.id.price_item_detals);
        add_to_card_btn=findViewById(R.id.add_to_card_btn);
        ratingBar=findViewById(R.id.ratingBar);
        coordinatorLayout=findViewById(R.id.main);
        quntitiy=findViewById(R.id.contact_quntity);
        nestedScrollView=findViewById(R.id.scrollView2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        toolbar=findViewById(R.id.colapsing_toolbar);
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        name=getIntent().getStringExtra("name");
        toolbar.setTitle(name);
        setSupportActionBar(toolbar);
        originalToolbarTitle=toolbar.getTitle().toString();
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.x_symbol_svgrepo_com);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getintentextra();
        getvariable();
        addItemCart();
        getnumIncreament();


       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            nestedScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                                if (scrollY==0) {
                                    //at top
                                    toolbar.setTitle(null);
                                }  else if (scrollY>oldScrollY) {
                                    //scroll down
                                    toolbar.setTitle(name);

                                }
                                //if scrolly<oldscroll scroll up
                                //if scrolly>0 scroll down
                                //at scroll y=0 at top of screen

                }
            });

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        ImageView imageView = (ImageView) menu.findItem(R.id.likeimage).getActionView();
        imageView.setOnClickListener(v->{
            if (flag == false) {
                imageView.setImageResource(R.drawable.like);
                flag = true;
            } else if (flag == true) {
                imageView.setImageResource(R.drawable.red_heart_svgrepo_com);
                flag = false;
            }
        });




        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d("onoff",item.getItemId()+"");
       if(item.getItemId()==android.R.id.home){
           finish();
           return true;
       } else if (item.getItemId()==R.id.share) {
           return true;
       }

       return false;
    }

    public void getintentextra(){
        foodId=getIntent().getIntExtra("id_food",0);
        DatabaseAcces.getInstance(this).openRead();
        object=DatabaseAcces.getInstance(this).FetchFoods(foodId);
        DatabaseAcces.getInstance(this).close();
        if(object.isIncart()){
            add_to_card_btn.setVisibility(View.GONE);
            quntitiy.setVisibility(View.VISIBLE);
        }else{
            add_to_card_btn.setVisibility(View.VISIBLE);
            quntitiy.setVisibility(View.GONE);
        }


    }

    private void getvariable() {
        if(object!=null){
            image_item.setImageURI(Uri.parse(object.getImagepath()));
            price_item.setText(String.format(Locale.getDefault(), "$%.2f", object.getPrice()));
            title_item.setText(object.getTitle());
            details_item.setText(object.getDescription());
            text_rating.setText(object.getStar() + " Rating");
            ratingBar.setRating((float) object.getStar());
            price_item_detals.setText(String.format(Locale.getDefault(), "$%.2f", object.getNumberInCart()* object.getPrice()));
            number_item.setText(object.getNumberInCart()+"");

        }

    }
    private void getnumIncreament() {

        plus_item.setOnClickListener(v->{
            num=object.getNumberInCart();
            ++num;
            object.setNumberInCart(num);
            object.setIncart(true);
            if(num==1){
                minus_btn.setText("");
                minus_btn.setBackground(getDrawable(R.drawable.delete_2_svgrepo_com));
            }else{
                minus_btn.setText("━");
                minus_btn.setBackground(null);
                DatabaseAcces.getInstance(this).openWrite();
                DatabaseAcces.getInstance(getApplicationContext()).UpdateCart(object);
                DatabaseAcces.getInstance(this).close();
            }

            number_item.setText(String.valueOf(num));

            getvariable();

        });

        minus_btn.setOnClickListener(v->{
            minus_btn.setText("━");
            minus_btn.setBackground(null);
            num=object.getNumberInCart();
            --num;
            object.setNumberInCart(num);
            object.setIncart(true);
            DatabaseAcces.getInstance(this).openWrite();
            if(num==1){
                minus_btn.setText("");
                minus_btn.setBackground(getDrawable(R.drawable.delete_2_svgrepo_com));
            }
            else if(num==0){
                minus_btn.setText("━");
                minus_btn.setBackground(null);
                object.setIncart(false);
                DatabaseAcces.getInstance(this).DeleteCart(object);
                quntitiy.setVisibility(View.GONE);
                add_to_card_btn.setVisibility(View.VISIBLE);
            }else{
                minus_btn.setText("━");
                minus_btn.setBackground(null);
                DatabaseAcces.getInstance(getApplicationContext()).UpdateCart(object);
            }
            DatabaseAcces.getInstance(this).close();
            number_item.setText(String.valueOf(num));
            getvariable();

        });

    }

    public void addItemCart(){
        add_to_card_btn.setOnClickListener(v->{
            add_to_card_btn.setVisibility(View.GONE);
            object.setNumberInCart(1);
            minus_btn.setText("");
            minus_btn.setBackground(getDrawable(R.drawable.delete_2_svgrepo_com));
            object.setIncart(true);
            DatabaseAcces.getInstance(this).openWrite();
            DatabaseAcces.getInstance(this).InsertCart(object);
            DatabaseAcces.getInstance(this).close();
            getvariable();
            quntitiy.setVisibility(View.VISIBLE);

        });
    }


}