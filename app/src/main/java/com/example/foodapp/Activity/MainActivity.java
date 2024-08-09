package com.example.foodapp.Activity;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.foodapp.Adapter.BestFoodAddapter;
import com.example.foodapp.Adapter.CategoryAddapter;
import com.example.foodapp.Adapter.Food_list_Adapter;
import com.example.foodapp.CostumeClick.ClickListnerplus;
import com.example.foodapp.CostumeClick.Clickevent;
import com.example.foodapp.Database.DatabaseAcces;
import com.example.foodapp.Domain.Category;
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.Domain.Location;
import com.example.foodapp.Domain.Price;
import com.example.foodapp.Domain.Time;
import com.example.foodapp.Helper.Cart;
import com.example.foodapp.Helper.bestfood;
import com.example.foodapp.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView Welcome_tex_v;
    TextView Name_tex_v;
    TextView text_today_bestfood;
    TextView text_viewall;
    TextView textcatogry;
    static TextView notificationtext;
    ImageView Logout_btn,setting_image,search_image,cart_image,location_image_sp,image_time_sp,image_price_sp;
    TextView search;
    Spinner spinner_location_sp,spinner_time_sp,spinner_price_sp;
    RecyclerView recyclerView_bestfood_tody,recyclerView_category;
    ProgressBar progress_tody_best_food,progressBar_category;
    public static ArrayList<Foods> arrayList_bestfood;
    CoordinatorLayout coordinatorLayout;
    BestFoodAddapter bestFoodAddapter;

    public static int  x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logout_btn=findViewById(R.id.Logout_btn);
        setting_image=findViewById(R.id.setting_image);
        cart_image=findViewById(R.id.cart_image);
        Welcome_tex_v=findViewById(R.id.Welcome_tex_v);
        Name_tex_v=findViewById(R.id.Name_tex_v);
        text_today_bestfood=findViewById(R.id.text_today_bestfood);
        text_viewall=findViewById(R.id.text_viewall);
        search=findViewById(R.id.textsearch);
        spinner_location_sp=findViewById(R.id.spinner_location_sp);
        spinner_time_sp=findViewById(R.id.spinner_time_sp);
        spinner_price_sp=findViewById(R.id.spinner_price_sp);
        recyclerView_bestfood_tody=findViewById(R.id.recyclerView_bestfood_tody);
        recyclerView_category=findViewById(R.id.recyclerView_category);
        progress_tody_best_food=findViewById(R.id.progress_tody_best_food);
        progressBar_category=findViewById(R.id.progressBar_category);
        notificationtext=findViewById(R.id.notificationtext);
        coordinatorLayout=findViewById(R.id.main);
        arrayList_bestfood=new ArrayList<>();


        getWindow().setStatusBarColor(getResources().getColor(R.color.white));


        intbestfood();
        intLocation();
        intTime();
        intPrice();
        intcategoryfood();
        notification(getApplicationContext());
        seeall();
        search();
        cart_image.setOnClickListener(v->{
            Intent intent=new Intent(getApplicationContext(),CartActivity.class);
            startActivity(intent);
        });

        Logout_btn.setOnClickListener(v->{
            finish();
        });

    }

    private void seeall() {
        text_viewall.setOnClickListener(v->{
            Intent intent=new Intent(getApplicationContext(),List_FoodActivity.class);
            intent.putExtra("Result",RESULT_OK);
            intent.putExtra("name","Best's Food");
                startActivity(intent);


        });
    }
    private void search(){
       search.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getApplicationContext(),SearchActivity.class);
               startActivity(intent);
           }
       });

    }

    public static void notification(Context context) {
        DatabaseAcces.getInstance(context.getApplicationContext()).openRead();
        if(DatabaseAcces.getInstance(context).GetallCart().isEmpty()){
            notificationtext.setVisibility(View.GONE);
            DatabaseAcces.getInstance(context.getApplicationContext()).close();
        }
        else{
            notificationtext.setVisibility(View.VISIBLE);
            notificationtext.setText(String.valueOf(DatabaseAcces.getInstance(context).getnumberofcartinallitem()));

        }
    }

    private void intPrice() {
        DatabaseAcces.getInstance(this).openRead();


        ArrayAdapter<Price> arrayAdapter= new ArrayAdapter<>(MainActivity.this,R.layout.sp_items,DatabaseAcces.getInstance(this).GetallPrice());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_price_sp.setAdapter(arrayAdapter);
        DatabaseAcces.getInstance(this).close();

    }

    private void intTime() {
        DatabaseAcces.getInstance(this).openRead();


        ArrayAdapter<Time> arrayAdapter= new ArrayAdapter<>(MainActivity.this,R.layout.sp_items,DatabaseAcces.getInstance(this).GetallTime());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_time_sp.setAdapter(arrayAdapter);
        DatabaseAcces.getInstance(this).close();

    }

    private void intLocation() {
        DatabaseAcces.getInstance(this).openRead();

        ArrayAdapter<Location> arrayAdapter= new ArrayAdapter<>(MainActivity.this,R.layout.sp_items,DatabaseAcces.getInstance(this).GetallLocation());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_location_sp.setAdapter(arrayAdapter);
        DatabaseAcces.getInstance(this).close();


    }

    private void intbestfood() {
        DatabaseAcces.getInstance(getApplicationContext()).openRead();

        progress_tody_best_food.setVisibility(View.VISIBLE);
        DatabaseAcces.getInstance(this).openRead();
        bestFoodAddapter=new BestFoodAddapter(DatabaseAcces.getInstance(this).GetHalfBestFoods(), new Clickevent() {

            @Override
            public void onclick(int id,Foods foods, int postion) {
                 if(foods!=null){
                    Intent intent=new Intent(getApplicationContext(), DetailActivity.class);
                    intent.putExtra("id_food",foods.getId());
                     startActivity(intent);
                    bestFoodAddapter.notifyItemChanged(postion);
                    bestFoodAddapter.notifyDataSetChanged();
                     DatabaseAcces.getInstance(getApplicationContext()).close();


                 }
            }
        });
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false);
        recyclerView_bestfood_tody.setLayoutManager(layoutManager);
        progress_tody_best_food.setVisibility(View.GONE);
        recyclerView_bestfood_tody.setAdapter(bestFoodAddapter);
        DatabaseAcces.getInstance(this).close();


    }

    private void intcategoryfood() {
        DatabaseAcces.getInstance(getApplicationContext()).openRead();

        progressBar_category.setVisibility(View.VISIBLE);
        DatabaseAcces.getInstance(this).openWrite();
          CategoryAddapter categoryAddapter=new CategoryAddapter(DatabaseAcces.getInstance(this).GetallCategory());

        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getApplicationContext(),4);
        recyclerView_category.setLayoutManager(layoutManager);
        progressBar_category.setVisibility(View.GONE);
        recyclerView_category.setAdapter(categoryAddapter);
        DatabaseAcces.getInstance(getApplicationContext()).close();

    }



}