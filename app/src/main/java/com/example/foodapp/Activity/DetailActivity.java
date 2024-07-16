package com.example.foodapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.coordinatorlayout.widget.CoordinatorLayout;


import com.example.foodapp.Domain.Foods;
import com.example.foodapp.Helper.Cart;
import com.example.foodapp.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    static ImageView image_item;
    ImageView back_btn_detals;
    ImageView favorite_btn;
    ImageView image_clock;
    static TextView title_item;
    static TextView price_item;
    static TextView text_rating;
    TextView time_details;
    TextView text_detals;
    static TextView details_item;
    TextView quntity_text;
    TextView minus_btn;
    static TextView number_item;
    TextView plus_item;
    TextView total_price_txt;
    static TextView price_item_detals;
    Button add_to_card_btn;
    static RatingBar ratingBar;
    private static Foods object;
    private static Foods cart;
    public  static int num=1;
    boolean flag=true;
    CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        image_item=findViewById(R.id.image_item);
        back_btn_detals=findViewById(R.id.back_btn_detals);
        favorite_btn=findViewById(R.id.favorite_btn);
        image_clock=findViewById(R.id.image_clock);
        title_item=findViewById(R.id.title_item);
        price_item=findViewById(R.id.price_item);
        text_rating=findViewById(R.id.text_rating);
        time_details=findViewById(R.id.time_details);
        text_detals=findViewById(R.id.text_detals);
        details_item=findViewById(R.id.details_item);
        quntity_text=findViewById(R.id.quntity_text);
        minus_btn=findViewById(R.id.minus_btn);
        number_item=findViewById(R.id.number_item);
        plus_item=findViewById(R.id.plus_item);
        total_price_txt=findViewById(R.id.total_price_txt);
        price_item_detals=findViewById(R.id.price_item_detals);
        add_to_card_btn=findViewById(R.id.add_to_card_btn);
        ratingBar=findViewById(R.id.ratingBar);
        coordinatorLayout=findViewById(R.id.main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setStatusBarColor(getResources().getColor(R.color.black));
        getintentextra();
        getvariable();
        getnumIncreament();
        favorite();
        additemcart();

    }


    private void favorite() {
        favorite_btn.setOnClickListener(v->{

            if(flag==true){
                favorite_btn.setImageResource(R.mipmap.fav);
                flag=false;
            } else if (flag==false) {
                favorite_btn.setImageResource(R.drawable.favorite_white);

                flag=true;

            }
        });
    }

    private void getnumIncreament() {
        plus_item.setOnClickListener(v->{
           String x=number_item.getText().toString();
           int y=Integer.parseInt(x);
           ++y;
           number_item.setText(y+"");
           num=y;
           if(object!=null){
               price_item_detals.setText(String.format(Locale.getDefault(), "$%.2f",num * object.getPrice()));


           }else if (cart!=null) {
               price_item_detals.setText(String.format(Locale.getDefault(), "$%.2f",num * cart.getPrice()));

           }
        });
        minus_btn.setOnClickListener(v->{
            String x=number_item.getText().toString();
            int y=Integer.parseInt(x);
            if(y>0){
                --y;
                number_item.setText(y+"");
                num=y;
                if(object!=null){
                    price_item_detals.setText(String.format(Locale.getDefault(), "$%.2f",num * object.getPrice()));


                } else if (cart!=null) {
                    price_item_detals.setText(String.format(Locale.getDefault(), "$%.2f",num * cart.getPrice()));

                }
            }

        });
    }


    private void getvariable() {
        back_btn_detals.setOnClickListener(v->{
            finish();
        });
        if(object!=null) {
            image_item.setImageResource(object.getImagepath());
            price_item_detals.setText(String.format(Locale.getDefault(), "$%.2f", object.getPrice()));
            title_item.setText(object.getTitle());
            details_item.setText(object.getDescription());
            text_rating.setText(object.getStar() + " Rating");
            ratingBar.setRating((float) object.getStar());
            price_item_detals.setText(String.format(Locale.getDefault(), "$%.2f", object.getNumberInCart()* object.getPrice()));
            number_item.setText(object.getNumberInCart()+"");

        } else if (cart!=null) {
            image_item.setImageResource(cart.getImagepath());
            price_item_detals.setText(String.format(Locale.getDefault(), "$%.2f", cart.getPrice()));
            title_item.setText(cart.getTitle());
            details_item.setText(cart.getDescription());
            text_rating.setText(cart.getStar() + " Rating");
            ratingBar.setRating((float)cart.getStar());
            price_item_detals.setText(String.format(Locale.getDefault(), "$%.2f", cart.getNumberInCart()* cart.getPrice()));
            number_item.setText(cart.getNumberInCart()+"");

        }
    }

    private void getintentextra() {
        object=(Foods) getIntent().getSerializableExtra("object");
        cart=(Foods) getIntent().getSerializableExtra("cart");
    }

    public void additemcart() {
        add_to_card_btn.setOnClickListener(v -> {
            Foods foodstoadd=null;
                if(object!=null){
                    foodstoadd=object;
                } else if (cart!=null) {
                    foodstoadd=cart;
                }
            if(foodstoadd!=null) {
                    num=Integer.parseInt(number_item.getText().toString());
                    boolean flag=true;
                    foodstoadd.setNumberInCart(num);
                if(num!=0){
                    flag = Cart.getInstance().additem(getApplicationContext(), foodstoadd);
                        MainActivity.notification();
                        setResult(RESULT_OK);


                }
                    Snackbar  snackbar1 = Snackbar.make(coordinatorLayout, "Your item added to Cart", Snackbar.LENGTH_SHORT);
                    snackbar1.setTextColor(getResources().getColor(R.color.orange));
                    snackbar1.setBackgroundTint(getResources().getColor(R.color.blue_grey));
                    Button snakbar_action = snackbar1.getView().findViewById(com.google.android.material.R.id.snackbar_action);
                    snakbar_action.setTextColor(getResources().getColor(R.color.orange));
                    if (flag == true) {
                        if(num==0){
                            Cart.getInstance().deleteitem1(getApplicationContext(),foodstoadd);
                            snackbar1.setText("Item deleted");
                            snackbar1.setAction("Undo", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Cart.getInstance().restoreLastRemovedItem();
                                    MainActivity.notification();

                                }
                            });
                            snackbar1.show();


                        }
                        else{
                            snackbar1.dismiss();

                        }

                    } else {
                        Foods finalFoodstoadd = foodstoadd;
                        snackbar1.setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Cart.getInstance().deleteitem(getApplicationContext(), finalFoodstoadd);
                                MainActivity.notification();

                            }
                        });
                        snackbar1.show();
                    }

                }




        });


    }


}